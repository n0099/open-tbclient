package com.baidu.searchbox.dns.d.c;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes10.dex */
public abstract class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int aj;
    public boolean ak;
    public int al;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.aj = 0;
        this.ak = false;
        this.al = w();
    }

    private T Q() {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!this.ak) {
                HttpURLConnection httpURLConnection2 = null;
                String url = getUrl();
                if (DnsUtil.DEBUG) {
                    String str = " sendRequest url:" + url;
                }
                if (!TextUtils.isEmpty(url)) {
                    try {
                        try {
                            if (!v()) {
                                httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                            } else {
                                httpURLConnection = (HttpsURLConnection) new URL(url).openConnection();
                            }
                            httpURLConnection2 = httpURLConnection;
                            httpURLConnection2.setRequestProperty("Charsert", "UTF-8");
                            httpURLConnection2.setConnectTimeout(30000);
                            httpURLConnection2.setReadTimeout(30000);
                            a(httpURLConnection2);
                            httpURLConnection2.connect();
                            b(httpURLConnection2);
                            c(httpURLConnection2);
                            return m(d(httpURLConnection2));
                        } catch (Exception e2) {
                            throw new com.baidu.searchbox.dns.d.c.a.a(e2.getMessage());
                        }
                    } finally {
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    }
                }
                throw new com.baidu.searchbox.dns.d.c.a.b("url is empty");
            }
            throw new com.baidu.searchbox.dns.d.c.a.b(10002, "request canceled");
        }
        return (T) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = Build.VERSION.RELEASE;
            if (str.length() > 0) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append("1.0");
            }
            if ("REL".equals(Build.VERSION.CODENAME)) {
                String str2 = Build.MODEL;
                if (str2.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(str2);
                }
            }
            String str3 = Build.ID;
            if (str3.length() > 0) {
                stringBuffer.append(" Build/");
                stringBuffer.append(str3);
            }
            return String.format("Mozilla/5.0 (Linux; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", stringBuffer);
        }
        return (String) invokeV.objValue;
    }

    public abstract void a(Exception exc);

    public void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, httpURLConnection) == null) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            httpURLConnection.setRequestProperty("User-Agent", P());
        }
    }

    public abstract void b(HttpURLConnection httpURLConnection);

    public String c(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, map)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String obj = entry.getValue().toString();
                try {
                    sb.append(entry.getKey() + "=" + URLEncoder.encode(obj, "UTF-8"));
                    sb.append("&");
                } catch (UnsupportedEncodingException unused) {
                    return null;
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public abstract void c(int i2);

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x005d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.HttpURLConnection, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpURLConnection)) != null) {
            return (String) invokeL.objValue;
        }
        InputStream inputStream = null;
        try {
            try {
                String contentEncoding = httpURLConnection.getContentEncoding();
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    httpURLConnection = inputStream2;
                    if (!TextUtils.isEmpty(contentEncoding)) {
                        httpURLConnection = inputStream2;
                        if (contentEncoding.equals("gzip")) {
                            httpURLConnection = new GZIPInputStream(inputStream2);
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader((InputStream) httpURLConnection, "utf-8"));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(new String(readLine.getBytes("utf-8"), "utf-8"));
                }
                String stringBuffer2 = stringBuffer.toString();
                if (httpURLConnection != 0) {
                    try {
                        httpURLConnection.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return stringBuffer2;
            } catch (Exception e5) {
                e = e5;
                throw new com.baidu.searchbox.dns.d.c.a.b(e.getMessage());
            } catch (Throwable th2) {
                th = th2;
                inputStream = httpURLConnection;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (inputStream != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? 403 == i2 || 404 == i2 : invokeI.booleanValue;
    }

    public abstract Map<String, Object> getParameters();

    public abstract String getUrl();

    public abstract T m(String str);

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public T x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.aj = 0;
            while (this.aj <= this.al) {
                try {
                    try {
                        return Q();
                    } catch (com.baidu.searchbox.dns.d.c.a.a e2) {
                        a(e2);
                    }
                } catch (com.baidu.searchbox.dns.d.c.a.b e3) {
                    if (e3.R() == 10001) {
                        c(e3.S());
                        return null;
                    }
                    a(e3);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public void a(com.baidu.searchbox.dns.d.c.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            int i2 = this.aj + 1;
            this.aj = i2;
            if (i2 <= this.al) {
                SystemClock.sleep(5000L);
            } else if (aVar.R() == 10001) {
                throw new com.baidu.searchbox.dns.d.c.a.b(aVar.R(), aVar.S(), " retry count reach fail ");
            } else {
                throw new com.baidu.searchbox.dns.d.c.a.b(" retry count reach fail ");
            }
        }
    }

    public void c(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, httpURLConnection) == null) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    String str = " http response error -> " + responseCode;
                    if (d(responseCode)) {
                        throw new com.baidu.searchbox.dns.d.c.a.b(10001, responseCode, str);
                    }
                    throw new com.baidu.searchbox.dns.d.c.a.a(10001, responseCode, str);
                }
            } catch (IOException e2) {
                throw new com.baidu.searchbox.dns.d.c.a.a(e2.getMessage());
            }
        }
    }
}
