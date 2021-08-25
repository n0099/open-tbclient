package c.a.m0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import c.a.m0.l.f;
import c.a.m0.l.g;
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
    public Context f4202a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f4203b;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f4204c;

    /* renamed from: d  reason: collision with root package name */
    public String f4205d;

    /* renamed from: e  reason: collision with root package name */
    public String f4206e;

    /* renamed from: f  reason: collision with root package name */
    public int f4207f;

    /* renamed from: g  reason: collision with root package name */
    public int f4208g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4209h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4210i;

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
        this.f4203b = new byte[1024];
        this.f4207f = 10000;
        this.f4208g = 10000;
        this.f4209h = false;
        this.f4210i = false;
        this.f4202a = context;
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
                if (c.a.m0.l.c.k(this.f4202a) == 0) {
                    return null;
                }
                HttpURLConnection c2 = c(map);
                this.f4204c = c2;
                if (c2 == null) {
                    return null;
                }
                if (bArr == null) {
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(c2.getContentEncoding())) {
                        this.f4209h = true;
                    } else {
                        this.f4209h = false;
                    }
                    this.f4204c.getResponseCode();
                    return this.f4204c.getInputStream();
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.f4204c.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(this.f4204c.getContentEncoding())) {
                        this.f4209h = true;
                    } else {
                        this.f4209h = false;
                    }
                    this.f4204c.getResponseCode();
                    InputStream inputStream = this.f4204c.getInputStream();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable th) {
                        c.a.m0.l.c.d(th);
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
                            c.a.m0.l.c.d(th3);
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
                HttpURLConnection httpURLConnection = this.f4204c;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.f4204c = null;
                }
                return null;
            }
            try {
                String f2 = f(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.f4204c;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    this.f4204c = null;
                }
                return f2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection3 = this.f4204c;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.f4204c = null;
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
            if (this.f4210i || TextUtils.isEmpty(this.f4205d) || TextUtils.isEmpty(this.f4206e)) {
                return null;
            }
            if (!this.f4205d.equals("POST") && !this.f4205d.equals("GET")) {
                this.f4205d = "POST";
            }
            URL url = new URL(this.f4206e);
            int i2 = 80;
            if (2 != c.a.m0.l.c.k(this.f4202a)) {
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
                    str = Proxy.getHost(this.f4202a);
                    i2 = Proxy.getPort(this.f4202a);
                }
            }
            if (str != null && i2 > 0) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2)));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (this.f4206e.startsWith("https")) {
                c.b((HttpsURLConnection) httpURLConnection);
            }
            httpURLConnection.setRequestMethod(this.f4205d);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.f4205d)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.f4207f);
            httpURLConnection.setReadTimeout(this.f4208g);
            httpURLConnection.setRequestProperty("x-device-id", g.b(c.a.m0.l.d.f(this.f4202a)));
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            String str2 = c.a.m0.a.f4058b;
            String h2 = c.a.m0.l.c.h(this.f4202a);
            httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + h2 + "/1.0.7");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
            StringBuilder sb = new StringBuilder();
            sb.append("sso/");
            sb.append("1.0.7");
            httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
            httpURLConnection.setRequestProperty("x-plu-ver", "sso/1.0.7");
            httpURLConnection.setRequestProperty("x-app-ver", this.f4202a.getPackageName() + "/" + c.a.m0.l.c.h(this.f4202a));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("android/");
            sb2.append(c.a.m0.l.c.g());
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
            this.f4205d = str;
            this.f4206e = str2;
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
            int read = inputStream.read(this.f4203b);
            if (read != -1) {
                byteArrayOutputStream.write(this.f4203b, 0, read);
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
            if (this.f4209h) {
                e2 = f.d(e2);
            }
            return e2 == null ? "" : new String(e2);
        }
        return (String) invokeL.objValue;
    }
}
