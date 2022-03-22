package c.a.l0.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import c.a.l0.m.f;
import c.a.l0.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;
@SuppressLint({"TrulyRandom"})
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3627b;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f3628c;

    /* renamed from: d  reason: collision with root package name */
    public String f3629d;

    /* renamed from: e  reason: collision with root package name */
    public String f3630e;

    /* renamed from: f  reason: collision with root package name */
    public int f3631f;

    /* renamed from: g  reason: collision with root package name */
    public int f3632g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3633h;
    public boolean i;

    public b(Context context, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3627b = new byte[1024];
        this.f3631f = 10000;
        this.f3632g = 10000;
        this.f3633h = false;
        this.i = false;
        this.a = context;
    }

    public final InputStream a(byte[] bArr, Map<String, String> map, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, bArr, map, str)) != null) {
            return (InputStream) invokeLLL.objValue;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (c.a.l0.m.c.j(this.a) == 0) {
                    return null;
                }
                HttpURLConnection c2 = c(map);
                this.f3628c = c2;
                if (c2 == null) {
                    return null;
                }
                if (bArr == null) {
                    if ("gzip".equalsIgnoreCase(c2.getContentEncoding())) {
                        this.f3633h = true;
                    } else {
                        this.f3633h = false;
                    }
                    this.f3628c.getResponseCode();
                    return this.f3628c.getInputStream();
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.f3628c.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    if ("gzip".equalsIgnoreCase(this.f3628c.getContentEncoding())) {
                        this.f3633h = true;
                    } else {
                        this.f3633h = false;
                    }
                    this.f3628c.getResponseCode();
                    InputStream inputStream = this.f3628c.getInputStream();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable th) {
                        c.a.l0.m.c.d(th);
                    }
                    return inputStream;
                } catch (Exception e2) {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable th3) {
                            c.a.l0.m.c.d(th3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public String b(String str, byte[] bArr, Map<String, String> map) {
        InterceptResult invokeLLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, map)) != null) {
            return (String) invokeLLL.objValue;
        }
        d("POST", str);
        try {
            inputStream = a(bArr, map, str);
            if (inputStream == null) {
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection = this.f3628c;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.f3628c = null;
                }
                return null;
            }
            try {
                String f2 = f(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.f3628c;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    this.f3628c = null;
                }
                return f2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection3 = this.f3628c;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.f3628c = null;
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public final HttpURLConnection c(Map<String, String> map) {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            String str = null;
            if (this.i || TextUtils.isEmpty(this.f3629d) || TextUtils.isEmpty(this.f3630e)) {
                return null;
            }
            if (!this.f3629d.equals("POST") && !this.f3629d.equals("GET")) {
                this.f3629d = "POST";
            }
            URL url = new URL(this.f3630e);
            int i = 80;
            if (2 != c.a.l0.m.c.j(this.a)) {
                if (Build.VERSION.SDK_INT >= 13) {
                    str = System.getProperties().getProperty("http.proxyHost");
                    String property = System.getProperties().getProperty("http.proxyPort");
                    if (!TextUtils.isEmpty(property)) {
                        try {
                            i = Integer.parseInt(property);
                        } catch (Throwable unused) {
                            i = -1;
                        }
                    }
                    i = -1;
                } else {
                    str = Proxy.getHost(this.a);
                    i = Proxy.getPort(this.a);
                }
            }
            if (str != null && i > 0) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (this.f3630e.startsWith("https")) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            }
            httpURLConnection.setRequestMethod(this.f3629d);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.f3629d)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.f3631f);
            httpURLConnection.setReadTimeout(this.f3632g);
            httpURLConnection.setRequestProperty("x-device-id", g.b(c.a.l0.m.d.a(this.a)));
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            String str2 = c.a.l0.a.f3508b;
            String g2 = c.a.l0.m.c.g(this.a);
            httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + g2 + "/1.1.1");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
            StringBuilder sb = new StringBuilder();
            sb.append("sso/");
            sb.append("1.1.1");
            httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
            httpURLConnection.setRequestProperty("x-plu-ver", "sso/1.1.1");
            httpURLConnection.setRequestProperty("x-app-ver", this.a.getPackageName() + "/" + c.a.l0.m.c.g(this.a));
            if (map != null) {
                for (String str3 : map.keySet()) {
                    httpURLConnection.setRequestProperty(str3, map.get(str3));
                }
            }
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f3629d = str;
            this.f3630e = str2;
        }
    }

    public final byte[] e(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(this.f3627b);
            if (read != -1) {
                byteArrayOutputStream.write(this.f3627b, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public final String f(InputStream inputStream) {
        InterceptResult invokeL;
        byte[] e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, inputStream)) == null) {
            if (inputStream == null || (e2 = e(inputStream)) == null) {
                return null;
            }
            if (this.f3633h) {
                e2 = f.d(e2);
            }
            return e2 == null ? "" : new String(e2);
        }
        return (String) invokeL.objValue;
    }
}
