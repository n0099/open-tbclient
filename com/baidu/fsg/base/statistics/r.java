package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes10.dex */
public class r {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "logsender";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void onSuccess();
    }

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, map)) == null) {
            StringBuilder sb = new StringBuilder();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey());
                    String encode2 = URLEncoder.encode(entry.getValue());
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                    sb.append("&");
                }
            }
            return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, Map<String, String> map, a aVar) {
        Exception e2;
        Throwable th;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, map, aVar) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                boolean z = false;
                try {
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    String a2 = a(map);
                    httpURLConnection.setFixedLengthStreamingMode(a2.length());
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.connect();
                    if (a2.length() > 0) {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(a2.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (200 <= responseCode && 300 > responseCode) {
                        z = true;
                    }
                    if (z) {
                        aVar.onSuccess();
                    } else {
                        aVar.a();
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    httpURLConnection2 = httpURLConnection;
                    try {
                        e2.printStackTrace();
                        LogUtil.d("logsender", e2.toString());
                        aVar.a();
                        if (httpURLConnection2 != null) {
                            httpURLConnection = httpURLConnection2;
                            httpURLConnection.disconnect();
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection2 = httpURLConnection;
                    th = th;
                    if (httpURLConnection2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
            } catch (Throwable th4) {
                th = th4;
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
            httpURLConnection.disconnect();
        }
    }
}
