package com.baidu.down.loopj.android.request.handler;

import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.down.utils.NamingThreadFactory;
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
/* loaded from: classes4.dex */
public final class HttpDns {
    private static final String ACCOUNT_ID = "0024";
    private static final int EMPTY_RESULT_HOST_TTL = 300;
    private static final int MAX_HOLD_HOST_NUM = 100;
    private static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    private static final String TAG = "HttpDns";
    private static String serverIp = "180.76.76.112/v2";
    private static HttpDns instance = new HttpDns();
    private boolean isExpiredIpAvailable = false;
    private CopyOnWriteArrayList<String> mRequstingHost = new CopyOnWriteArrayList<>();
    private ConcurrentMap<String, HostObject> hostManager = new ConcurrentHashMap();
    private ExecutorService pool = Executors.newCachedThreadPool(new NamingThreadFactory(TAG));
    private DegradationFilter degradationFilter = null;

    public void setPreResolveHosts(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (!this.hostManager.containsKey(str) && !this.mRequstingHost.contains(str)) {
                    this.pool.submit(new QueryHostTask(str));
                    this.mRequstingHost.add(str);
                }
            }
        }
    }

    public void setHttpDnsServerIp(String str) {
        serverIp = str;
    }

    public void resetCacheIps() {
        this.hostManager.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class HostObject {
        private String hostName;
        private String[] ip;
        private long mQueryTime;
        private long mTtl;

        HostObject() {
        }

        public String toString() {
            return "HostObject [hostName=" + this.hostName + ", ip=" + this.ip + ", mTtl=" + this.mTtl + ", mQueryTime=" + this.mQueryTime + "]";
        }

        public boolean isExpired() {
            return Math.abs((getmQueryTime() + this.mTtl) - (System.currentTimeMillis() / 1000)) < 0;
        }

        public String[] getIp() {
            return this.ip;
        }

        public void setIp(String[] strArr) {
            this.ip = strArr;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        public String getHostName() {
            return this.hostName;
        }

        public long getmTtl() {
            return this.mTtl;
        }

        public void setmTtl(long j) {
            this.mTtl = j;
        }

        public long getmQueryTime() {
            return this.mQueryTime;
        }

        public void setmQueryTime(long j) {
            this.mQueryTime = j;
        }
    }

    /* loaded from: classes4.dex */
    class QueryHostTask implements Callable<String[]> {
        private String hostName;
        private boolean isRequestRetried = false;

        QueryHostTask(String str) {
            this.hostName = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [283=7, 284=6, 286=6, 288=6, 289=6, 290=6, 293=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x021f  */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String[] call() {
            InputStream inputStream;
            InputStream inputStream2;
            HttpURLConnection httpURLConnection;
            InputStream inputStream3;
            HttpURLConnection httpURLConnection2 = null;
            String str = "http://" + HttpDns.serverIp + "/" + HttpDns.ACCOUNT_ID + "/?dn=" + this.hostName;
            Log.v(HttpDns.TAG, "[QueryHostTask.call] - buildUrl: " + str);
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setReadTimeout(10000);
                    if (httpURLConnection3.getResponseCode() != 200) {
                        Log.w(HttpDns.TAG, "[QueryHostTask.call] - response code: " + httpURLConnection3.getResponseCode());
                        inputStream3 = null;
                    } else {
                        inputStream = httpURLConnection3.getInputStream();
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
                            long j = jSONObject.getLong("ttl");
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                long j2 = j == 0 ? 300L : j;
                                HostObject hostObject = new HostObject();
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.hostName);
                                if (optJSONObject2 == null) {
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    HttpDns.this.mRequstingHost.remove(this.hostName);
                                    return null;
                                }
                                JSONArray optJSONArray = optJSONObject2.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                                if (optJSONArray == null) {
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    HttpDns.this.mRequstingHost.remove(this.hostName);
                                    return null;
                                }
                                String[] strArr = new String[optJSONArray.length()];
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    strArr[i] = optJSONArray.getString(i);
                                    Log.v(HttpDns.TAG, "[QueryHostTask.call] - resolve host:" + this.hostName + " ip:" + strArr[i] + " mTtl:" + j2);
                                }
                                hostObject.setHostName(this.hostName);
                                hostObject.setmTtl(j2);
                                hostObject.setIp(strArr);
                                hostObject.setmQueryTime(System.currentTimeMillis() / 1000);
                                if (HttpDns.this.hostManager.size() < 100) {
                                    HttpDns.this.hostManager.put(this.hostName, hostObject);
                                }
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
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
                            inputStream.close();
                            inputStream3 = null;
                        } catch (Exception e4) {
                            httpURLConnection = httpURLConnection3;
                            inputStream2 = inputStream;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            HttpDns.this.mRequstingHost.remove(this.hostName);
                            if (this.isRequestRetried) {
                            }
                        } catch (Throwable th) {
                            httpURLConnection2 = httpURLConnection3;
                            th = th;
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
                    httpURLConnection3.disconnect();
                    if (0 != 0) {
                        httpURLConnection2.disconnect();
                    }
                    if (0 != 0) {
                        try {
                            inputStream3.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    HttpDns.this.mRequstingHost.remove(this.hostName);
                } catch (Exception e8) {
                    httpURLConnection = httpURLConnection3;
                    inputStream2 = null;
                } catch (Throwable th2) {
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                }
            } catch (Exception e9) {
                inputStream2 = null;
                httpURLConnection = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            if (this.isRequestRetried) {
                this.isRequestRetried = true;
                return call();
            }
            return null;
        }
    }

    private HttpDns() {
    }

    public static HttpDns getInstance() {
        return instance;
    }

    public void setExpiredIPAvailable(boolean z) {
        this.isExpiredIpAvailable = z;
    }

    public boolean isExpiredIpAvailable() {
        return this.isExpiredIpAvailable;
    }

    public synchronized String[] getIpByHost(String str) {
        String[] strArr;
        if (this.degradationFilter != null && this.degradationFilter.shouldDegradeHttpDNS(str)) {
            Log.v(TAG, "[degradationFilter] - degradationFilter Degrade " + str);
            strArr = null;
        } else {
            HostObject hostObject = this.hostManager.get(str);
            if ((hostObject == null || (hostObject.isExpired() && !isExpiredIpAvailable())) && !this.mRequstingHost.contains(str)) {
                Log.v(TAG, "[getIpByHost] - fetch result from network, host: " + str);
                Future submit = this.pool.submit(new QueryHostTask(str));
                this.mRequstingHost.add(str);
                try {
                    strArr = (String[]) submit.get(3L, TimeUnit.SECONDS);
                } catch (Exception e) {
                    this.mRequstingHost.remove(str);
                    strArr = null;
                }
            } else {
                strArr = hostObject == null ? null : hostObject.getIp();
            }
        }
        return strArr;
    }

    public void setDegradationFilter(DegradationFilter degradationFilter) {
        this.degradationFilter = degradationFilter;
    }
}
