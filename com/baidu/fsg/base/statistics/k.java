package com.baidu.fsg.base.statistics;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39321a = "logsender";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public k() {
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

    public void a(String str, Map<String, String> map, a aVar) {
        HttpURLConnection httpURLConnection;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, map, aVar) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    z = false;
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
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
                    aVar.a();
                } else {
                    aVar.b();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e3) {
                e = e3;
                httpURLConnection2 = httpURLConnection;
                e.printStackTrace();
                LogUtil.d("logsender", e.toString());
                aVar.b();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
    }
}
