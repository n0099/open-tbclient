package com.baidu.down.loopj.android.request.handler;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.utils.NamingThreadFactory;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCOUNT_ID = "0024";
    public static final int EMPTY_RESULT_HOST_TTL = 300;
    public static final int MAX_HOLD_HOST_NUM = 100;
    public static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    public static final String TAG = "HttpDns";
    public static HttpDns instance = null;
    public static String serverIp = "180.76.76.112/v2";
    public transient /* synthetic */ FieldHolder $fh;
    public DegradationFilter degradationFilter;
    public ConcurrentMap<String, HostObject> hostManager;
    public boolean isExpiredIpAvailable;
    public CopyOnWriteArrayList<String> mRequstingHost;
    public ExecutorService pool;

    /* loaded from: classes2.dex */
    public class HostObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String hostName;
        public String[] ip;
        public long mQueryTime;
        public long mTtl;
        public final /* synthetic */ HttpDns this$0;

        public HostObject(HttpDns httpDns) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDns};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpDns;
        }

        public String getHostName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hostName : (String) invokeV.objValue;
        }

        public String[] getIp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ip : (String[]) invokeV.objValue;
        }

        public long getmQueryTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mQueryTime : invokeV.longValue;
        }

        public long getmTtl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTtl : invokeV.longValue;
        }

        public boolean isExpired() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Math.abs((getmQueryTime() + this.mTtl) - (System.currentTimeMillis() / 1000)) < 0 : invokeV.booleanValue;
        }

        public void setHostName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.hostName = str;
            }
        }

        public void setIp(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
                this.ip = strArr;
            }
        }

        public void setmQueryTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                this.mQueryTime = j;
            }
        }

        public void setmTtl(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
                this.mTtl = j;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "HostObject [hostName=" + this.hostName + ", ip=" + this.ip + ", mTtl=" + this.mTtl + ", mQueryTime=" + this.mQueryTime + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class QueryHostTask implements Callable<String[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String hostName;
        public boolean isRequestRetried;
        public final /* synthetic */ HttpDns this$0;

        public QueryHostTask(HttpDns httpDns, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDns, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpDns;
            this.isRequestRetried = false;
            this.hostName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01d4 A[RETURN] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String[] call() {
            InterceptResult invokeV;
            InputStream inputStream;
            HttpURLConnection httpURLConnection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                                    HostObject hostObject = new HostObject(this.this$0);
                                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.hostName);
                                    if (optJSONObject2 == null) {
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e) {
                                                e = e;
                                                e.printStackTrace();
                                                this.this$0.mRequstingHost.remove(this.hostName);
                                                return null;
                                            }
                                        }
                                    } else {
                                        JSONArray optJSONArray = optJSONObject2.optJSONArray("ip");
                                        if (optJSONArray != null) {
                                            String[] strArr = new String[optJSONArray.length()];
                                            for (int i = 0; i < optJSONArray.length(); i++) {
                                                strArr[i] = optJSONArray.getString(i);
                                                Log.v(HttpDns.TAG, "[QueryHostTask.call] - resolve host:" + this.hostName + " ip:" + strArr[i] + " mTtl:" + j);
                                            }
                                            hostObject.setHostName(this.hostName);
                                            hostObject.setmTtl(j);
                                            hostObject.setIp(strArr);
                                            hostObject.setmQueryTime(System.currentTimeMillis() / 1000);
                                            if (this.this$0.hostManager.size() < 100) {
                                                this.this$0.hostManager.put(this.hostName, hostObject);
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            this.this$0.mRequstingHost.remove(this.hostName);
                                            return strArr;
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e3) {
                                                e = e3;
                                                e.printStackTrace();
                                                this.this$0.mRequstingHost.remove(this.hostName);
                                                return null;
                                            }
                                        }
                                    }
                                    this.this$0.mRequstingHost.remove(this.hostName);
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
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                this.this$0.mRequstingHost.remove(this.hostName);
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
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                this.this$0.mRequstingHost.remove(this.hostName);
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
                this.this$0.mRequstingHost.remove(this.hostName);
                if (this.isRequestRetried) {
                    this.isRequestRetried = true;
                    return call();
                }
                return null;
            }
            return (String[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1592333863, "Lcom/baidu/down/loopj/android/request/handler/HttpDns;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1592333863, "Lcom/baidu/down/loopj/android/request/handler/HttpDns;");
                return;
            }
        }
        instance = new HttpDns();
    }

    public HttpDns() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isExpiredIpAvailable = false;
        this.mRequstingHost = new CopyOnWriteArrayList<>();
        this.hostManager = new ConcurrentHashMap();
        this.pool = Executors.newCachedThreadPool(new NamingThreadFactory(TAG));
        this.degradationFilter = null;
    }

    public static HttpDns getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? instance : (HttpDns) invokeV.objValue;
    }

    public synchronized String[] getIpByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
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
                Future submit = this.pool.submit(new QueryHostTask(this, str));
                this.mRequstingHost.add(str);
                try {
                    return (String[]) submit.get(3L, TimeUnit.SECONDS);
                } catch (Exception unused) {
                    this.mRequstingHost.remove(str);
                    return null;
                }
            }
        }
        return (String[]) invokeL.objValue;
    }

    public boolean isExpiredIpAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isExpiredIpAvailable : invokeV.booleanValue;
    }

    public void resetCacheIps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.hostManager.clear();
        }
    }

    public void setDegradationFilter(DegradationFilter degradationFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, degradationFilter) == null) {
            this.degradationFilter = degradationFilter;
        }
    }

    public void setExpiredIPAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isExpiredIpAvailable = z;
        }
    }

    public void setHttpDnsServerIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            serverIp = str;
        }
    }

    public void setPreResolveHosts(String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) || strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!this.hostManager.containsKey(str) && !this.mRequstingHost.contains(str)) {
                this.pool.submit(new QueryHostTask(this, str));
                this.mRequstingHost.add(str);
            }
        }
    }
}
