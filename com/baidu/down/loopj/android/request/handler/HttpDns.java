package com.baidu.down.loopj.android.request.handler;

import android.util.Log;
import com.baidu.down.utils.NamingThreadFactory;
import com.yy.gslbsdk.db.ResultTB;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class HttpDns {
    public static final String ACCOUNT_ID = "0024";
    public static final int EMPTY_RESULT_HOST_TTL = 300;
    public static final int MAX_HOLD_HOST_NUM = 100;
    public static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    public static final String TAG = "HttpDns";
    public static HttpDns instance = new HttpDns();
    public static String serverIp = "180.76.76.112/v2";
    public boolean isExpiredIpAvailable = false;
    public CopyOnWriteArrayList<String> mRequstingHost = new CopyOnWriteArrayList<>();
    public ConcurrentMap<String, HostObject> hostManager = new ConcurrentHashMap();
    public ExecutorService pool = Executors.newCachedThreadPool(new NamingThreadFactory(TAG));
    public DegradationFilter degradationFilter = null;

    /* loaded from: classes2.dex */
    public class HostObject {
        public String hostName;
        public String[] ip;
        public long mQueryTime;
        public long mTtl;

        public HostObject() {
        }

        public String getHostName() {
            return this.hostName;
        }

        public String[] getIp() {
            return this.ip;
        }

        public long getmQueryTime() {
            return this.mQueryTime;
        }

        public long getmTtl() {
            return this.mTtl;
        }

        public boolean isExpired() {
            return Math.abs((getmQueryTime() + this.mTtl) - (System.currentTimeMillis() / 1000)) < 0;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        public void setIp(String[] strArr) {
            this.ip = strArr;
        }

        public void setmQueryTime(long j) {
            this.mQueryTime = j;
        }

        public void setmTtl(long j) {
            this.mTtl = j;
        }

        public String toString() {
            return "HostObject [hostName=" + this.hostName + ", ip=" + this.ip + ", mTtl=" + this.mTtl + ", mQueryTime=" + this.mQueryTime + "]";
        }
    }

    /* loaded from: classes2.dex */
    public class QueryHostTask implements Callable<String[]> {
        public String hostName;
        public boolean isRequestRetried = false;

        public QueryHostTask(String str) {
            this.hostName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01d0 A[RETURN] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String[] call() {
            InputStream inputStream;
            HttpURLConnection httpURLConnection;
            String str = "http://" + HttpDns.serverIp + "/" + HttpDns.ACCOUNT_ID + "/?dn=" + this.hostName;
            Log.v(HttpDns.TAG, "[QueryHostTask.call] - buildUrl: " + str);
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    if (httpURLConnection.getResponseCode() != 200) {
                        Log.w(HttpDns.TAG, "[QueryHostTask.call] - response code: " + httpURLConnection.getResponseCode());
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            JSONObject jSONObject = new JSONObject(sb.toString());
                            long j = jSONObject.getLong(ResultTB.TTL);
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                if (j == 0) {
                                    j = 300;
                                }
                                HostObject hostObject = new HostObject();
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.hostName);
                                if (optJSONObject2 == null) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            HttpDns.this.mRequstingHost.remove(this.hostName);
                                            return null;
                                        }
                                    }
                                } else {
                                    JSONArray optJSONArray = optJSONObject2.optJSONArray("ip");
                                    if (optJSONArray != null) {
                                        String[] strArr = new String[optJSONArray.length()];
                                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                            strArr[i2] = optJSONArray.getString(i2);
                                            Log.v(HttpDns.TAG, "[QueryHostTask.call] - resolve host:" + this.hostName + " ip:" + strArr[i2] + " mTtl:" + j);
                                        }
                                        hostObject.setHostName(this.hostName);
                                        hostObject.setmTtl(j);
                                        hostObject.setIp(strArr);
                                        hostObject.setmQueryTime(System.currentTimeMillis() / 1000);
                                        if (HttpDns.this.hostManager.size() < 100) {
                                            HttpDns.this.hostManager.put(this.hostName, hostObject);
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        HttpDns.this.mRequstingHost.remove(this.hostName);
                                        return strArr;
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e4) {
                                            e = e4;
                                            e.printStackTrace();
                                            HttpDns.this.mRequstingHost.remove(this.hostName);
                                            return null;
                                        }
                                    }
                                }
                                HttpDns.this.mRequstingHost.remove(this.hostName);
                                return null;
                            }
                            inputStream.close();
                        } catch (Exception unused) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            HttpDns.this.mRequstingHost.remove(this.hostName);
                            if (this.isRequestRetried) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            HttpDns.this.mRequstingHost.remove(this.hostName);
                            throw th;
                        }
                    }
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
            } catch (Exception unused3) {
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            HttpDns.this.mRequstingHost.remove(this.hostName);
            if (this.isRequestRetried) {
                this.isRequestRetried = true;
                return call();
            }
            return null;
        }
    }

    public static HttpDns getInstance() {
        return instance;
    }

    public synchronized String[] getIpByHost(String str) {
        if (this.degradationFilter != null && this.degradationFilter.shouldDegradeHttpDNS(str)) {
            Log.v(TAG, "[degradationFilter] - degradationFilter Degrade " + str);
            return null;
        }
        HostObject hostObject = this.hostManager.get(str);
        if ((hostObject != null && (!hostObject.isExpired() || isExpiredIpAvailable())) || this.mRequstingHost.contains(str)) {
            if (hostObject == null) {
                return null;
            }
            return hostObject.getIp();
        }
        Log.v(TAG, "[getIpByHost] - fetch result from network, host: " + str);
        Future submit = this.pool.submit(new QueryHostTask(str));
        this.mRequstingHost.add(str);
        try {
            return (String[]) submit.get(3L, TimeUnit.SECONDS);
        } catch (Exception unused) {
            this.mRequstingHost.remove(str);
            return null;
        }
    }

    public boolean isExpiredIpAvailable() {
        return this.isExpiredIpAvailable;
    }

    public void resetCacheIps() {
        this.hostManager.clear();
    }

    public void setDegradationFilter(DegradationFilter degradationFilter) {
        this.degradationFilter = degradationFilter;
    }

    public void setExpiredIPAvailable(boolean z) {
        this.isExpiredIpAvailable = z;
    }

    public void setHttpDnsServerIp(String str) {
        serverIp = str;
    }

    public void setPreResolveHosts(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!this.hostManager.containsKey(str) && !this.mRequstingHost.contains(str)) {
                this.pool.submit(new QueryHostTask(str));
                this.mRequstingHost.add(str);
            }
        }
    }
}
