package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1894a = "msp";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1895b = "application/octet-stream;binary/octet-stream";

    /* renamed from: c  reason: collision with root package name */
    public static final CookieManager f1896c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.alipay.sdk.net.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0017a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f1897a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f1898b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, String> f1899c;

        public C0017a(String str, Map<String, String> map, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, map, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1897a = str;
            this.f1898b = bArr;
            this.f1899c = map;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("<UrlConnectionConfigure url=%s requestBody=%s headers=%s>", this.f1897a, this.f1898b, this.f1899c) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<String>> f1900a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1901b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f1902c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1900a = map;
            this.f1901b = str;
            this.f1902c = bArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(796329004, "Lcom/alipay/sdk/net/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(796329004, "Lcom/alipay/sdk/net/a;");
                return;
            }
        }
        f1896c = new CookieManager();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, C0017a c0017a) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        URL url;
        HttpURLConnection httpURLConnection2;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, c0017a)) == null) {
            if (context == null) {
                return null;
            }
            try {
                c.c(f1894a, "config : " + c0017a);
                url = new URL(c0017a.f1897a);
                Proxy a2 = a(context);
                c.c(f1894a, "proxy: " + a2);
                if (a2 != null) {
                    httpURLConnection2 = (HttpURLConnection) url.openConnection(a2);
                } else {
                    httpURLConnection2 = (HttpURLConnection) url.openConnection();
                }
                try {
                    System.setProperty("http.keepAlive", "false");
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                    }
                    if (f1896c.getCookieStore().getCookies().size() > 0) {
                        httpURLConnection2.setRequestProperty("Cookie", TextUtils.join(";", f1896c.getCookieStore().getCookies()));
                    }
                    httpURLConnection2.setConnectTimeout(20000);
                    httpURLConnection2.setReadTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    httpURLConnection2.setRequestProperty("User-Agent", f1894a);
                    if (c0017a.f1898b != null && c0017a.f1898b.length > 0) {
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setRequestProperty("Content-Type", f1895b);
                        httpURLConnection2.setRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection2.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                        httpURLConnection2.setRequestProperty(HTTP.CONN_KEEP_ALIVE, "timeout=180, max=100");
                    } else {
                        httpURLConnection2.setRequestMethod("GET");
                    }
                    if (c0017a.f1899c != null) {
                        for (Map.Entry<String, String> entry : c0017a.f1899c.entrySet()) {
                            if (entry.getKey() != null) {
                                httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    httpURLConnection2.setDoInput(true);
                    if ("POST".equals(httpURLConnection2.getRequestMethod())) {
                        httpURLConnection2.setDoOutput(true);
                    }
                    if ("POST".equals(httpURLConnection2.getRequestMethod())) {
                        bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            bufferedOutputStream2.write(c0017a.f1898b);
                            bufferedOutputStream2.flush();
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream = null;
                            Throwable th2 = th;
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            try {
                                c.a(th);
                                return null;
                            } finally {
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                            }
                        }
                    } else {
                        bufferedOutputStream2 = null;
                    }
                    bufferedInputStream2 = new BufferedInputStream(httpURLConnection2.getInputStream());
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            }
            try {
                byte[] a3 = a(bufferedInputStream2);
                Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                String join = (headerFields == null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                List<String> list = headerFields.get("Set-Cookie");
                if (list != null) {
                    for (String str : list) {
                        List<HttpCookie> parse = HttpCookie.parse(str);
                        if (parse != null && !parse.isEmpty()) {
                            f1896c.getCookieStore().add(url.toURI(), parse.get(0));
                        }
                    }
                }
                b bVar = new b(headerFields, join, a3);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable unused4) {
                    }
                }
                try {
                    bufferedInputStream2.close();
                } catch (Throwable unused5) {
                }
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable unused6) {
                    }
                }
                return bVar;
            } catch (Throwable th5) {
                httpURLConnection = httpURLConnection2;
                th = th5;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream = bufferedInputStream2;
                c.a(th);
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused7) {
                    }
                }
                return null;
            }
        }
        return (b) invokeLL.objValue;
    }

    public static NetworkInfo b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                NetworkInfo b2 = b(context);
                if (b2 != null && b2.isAvailable()) {
                    return b2.getType() == 1 ? "wifi" : b2.getExtraInfo().toLowerCase();
                }
            } catch (Exception unused) {
            }
            return "none";
        }
        return (String) invokeL.objValue;
    }

    public static Proxy a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String c2 = c(context);
            if (c2 == null || c2.contains("wap")) {
                try {
                    String property = System.getProperty("https.proxyHost");
                    String property2 = System.getProperty("https.proxyPort");
                    if (TextUtils.isEmpty(property)) {
                        return null;
                    }
                    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (Proxy) invokeL.objValue;
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
