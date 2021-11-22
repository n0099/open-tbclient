package b.a.n0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import b.a.n0.l.f;
import b.a.n0.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
@SuppressLint({"TrulyRandom"})
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3724a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3725b;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f3726c;

    /* renamed from: d  reason: collision with root package name */
    public String f3727d;

    /* renamed from: e  reason: collision with root package name */
    public String f3728e;

    /* renamed from: f  reason: collision with root package name */
    public int f3729f;

    /* renamed from: g  reason: collision with root package name */
    public int f3730g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3731h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3732i;

    public b(Context context, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3725b = new byte[1024];
        this.f3729f = 10000;
        this.f3730g = 10000;
        this.f3731h = false;
        this.f3732i = false;
        this.f3724a = context;
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
                if (b.a.n0.l.c.k(this.f3724a) == 0) {
                    return null;
                }
                HttpURLConnection c2 = c(map);
                this.f3726c = c2;
                if (c2 == null) {
                    return null;
                }
                if (bArr == null) {
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(c2.getContentEncoding())) {
                        this.f3731h = true;
                    } else {
                        this.f3731h = false;
                    }
                    this.f3726c.getResponseCode();
                    return this.f3726c.getInputStream();
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.f3726c.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(this.f3726c.getContentEncoding())) {
                        this.f3731h = true;
                    } else {
                        this.f3731h = false;
                    }
                    this.f3726c.getResponseCode();
                    InputStream inputStream = this.f3726c.getInputStream();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable th) {
                        b.a.n0.l.c.d(th);
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
                            b.a.n0.l.c.d(th3);
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
                HttpURLConnection httpURLConnection = this.f3726c;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.f3726c = null;
                }
                return null;
            }
            try {
                String f2 = f(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.f3726c;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    this.f3726c = null;
                }
                return f2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection3 = this.f3726c;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.f3726c = null;
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
            if (this.f3732i || TextUtils.isEmpty(this.f3727d) || TextUtils.isEmpty(this.f3728e)) {
                return null;
            }
            if (!this.f3727d.equals("POST") && !this.f3727d.equals("GET")) {
                this.f3727d = "POST";
            }
            URL url = new URL(this.f3728e);
            int i2 = 80;
            if (2 != b.a.n0.l.c.k(this.f3724a)) {
                if (Build.VERSION.SDK_INT >= 13) {
                    str = System.getProperties().getProperty("http.proxyHost");
                    String property = System.getProperties().getProperty("http.proxyPort");
                    if (!TextUtils.isEmpty(property)) {
                        try {
                            i2 = Integer.parseInt(property);
                        } catch (Throwable unused) {
                            i2 = -1;
                        }
                    }
                    i2 = -1;
                } else {
                    str = Proxy.getHost(this.f3724a);
                    i2 = Proxy.getPort(this.f3724a);
                }
            }
            if (str != null && i2 > 0) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2)));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (this.f3728e.startsWith("https")) {
                c.b((HttpsURLConnection) httpURLConnection);
            }
            httpURLConnection.setRequestMethod(this.f3727d);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.f3727d)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.f3729f);
            httpURLConnection.setReadTimeout(this.f3730g);
            httpURLConnection.setRequestProperty("x-device-id", g.b(b.a.n0.l.d.f(this.f3724a)));
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            String str2 = b.a.n0.a.f3581b;
            String h2 = b.a.n0.l.c.h(this.f3724a);
            httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + h2 + "/1.0.7");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
            StringBuilder sb = new StringBuilder();
            sb.append("sso/");
            sb.append("1.0.7");
            httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
            httpURLConnection.setRequestProperty("x-plu-ver", "sso/1.0.7");
            httpURLConnection.setRequestProperty("x-app-ver", this.f3724a.getPackageName() + "/" + b.a.n0.l.c.h(this.f3724a));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("android/");
            sb2.append(b.a.n0.l.c.g());
            httpURLConnection.setRequestProperty("x-sys-ver", sb2.toString());
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
            this.f3727d = str;
            this.f3728e = str2;
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
            int read = inputStream.read(this.f3725b);
            if (read != -1) {
                byteArrayOutputStream.write(this.f3725b, 0, read);
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
            if (this.f3731h) {
                e2 = f.d(e2);
            }
            return e2 == null ? "" : new String(e2);
        }
        return (String) invokeL.objValue;
    }
}
