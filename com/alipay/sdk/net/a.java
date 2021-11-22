package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.deeplink.DeepLinkManager1;
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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f34963a = "msp";

    /* renamed from: b  reason: collision with root package name */
    public static final String f34964b = "application/octet-stream;binary/octet-stream";

    /* renamed from: c  reason: collision with root package name */
    public static final CookieManager f34965c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.alipay.sdk.net.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1563a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f34966a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f34967b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, String> f34968c;

        public C1563a(String str, Map<String, String> map, byte[] bArr) {
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
            this.f34966a = str;
            this.f34967b = bArr;
            this.f34968c = map;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f34966a, this.f34968c) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<String>> f34969a;

        /* renamed from: b  reason: collision with root package name */
        public final String f34970b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f34971c;

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
            this.f34969a = map;
            this.f34970b = str;
            this.f34971c = bArr;
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
        f34965c = new CookieManager();
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

    /* JADX WARN: Removed duplicated region for block: B:118:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, C1563a c1563a) {
        InterceptResult invokeLL;
        Throwable th;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        URL url;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, c1563a)) == null) {
            if (context == null) {
                return null;
            }
            try {
                c.d(com.alipay.sdk.cons.a.x, "conn config: " + c1563a);
                url = new URL(c1563a.f34966a);
                Proxy c2 = c(context);
                c.d(com.alipay.sdk.cons.a.x, "conn proxy: " + c2);
                if (c2 != null) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(c2);
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
            try {
                System.setProperty("http.keepAlive", "false");
                if (httpURLConnection instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                }
                if (f34965c.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection.setRequestProperty("Cookie", TextUtils.join(";", f34965c.getCookieStore().getCookies()));
                }
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", f34963a);
                if (c1563a.f34967b != null && c1563a.f34967b.length > 0) {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", f34964b);
                    httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestProperty(HTTP.CONN_KEEP_ALIVE, "timeout=180, max=100");
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                if (c1563a.f34968c != null) {
                    for (Map.Entry<String, String> entry : c1563a.f34968c.entrySet()) {
                        if (entry.getKey() != null) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection.setDoInput(true);
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    httpURLConnection.setDoOutput(true);
                }
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream.write(c1563a.f34967b);
                        bufferedOutputStream.flush();
                    } catch (Throwable th4) {
                        th2 = th4;
                        bufferedInputStream = null;
                        try {
                            c.a(th2);
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
                    bufferedOutputStream = null;
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] a2 = a(bufferedInputStream);
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    String join = (headerFields == null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                    List<String> list = headerFields.get("Set-Cookie");
                    if (list != null) {
                        for (String str : list) {
                            List<HttpCookie> parse = HttpCookie.parse(str);
                            if (parse != null && !parse.isEmpty()) {
                                f34965c.getCookieStore().add(url.toURI(), parse.get(0));
                            }
                        }
                    }
                    b bVar = new b(headerFields, join, a2);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused5) {
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    return bVar;
                } catch (Throwable th5) {
                    th2 = th5;
                    c.a(th2);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused7) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                th2 = th;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                c.a(th2);
                return null;
            }
        }
        return (b) invokeLL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                NetworkInfo a2 = a(context);
                if (a2 != null && a2.isAvailable()) {
                    return a2.getType() == 1 ? "wifi" : a2.getExtraInfo().toLowerCase();
                }
            } catch (Exception unused) {
            }
            return "none";
        }
        return (String) invokeL.objValue;
    }

    public static Proxy c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String b2 = b(context);
            if (b2 == null || b2.contains(DeepLinkManager1.AD_WAP)) {
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

    public static NetworkInfo a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
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
