package c.f.a.g.d.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.a.g.a;
import c.f.a.g.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.RestDebugConfig;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.dxmpay.apollon.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
/* loaded from: classes7.dex */
public class b implements c.f.a.g.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f28551b;

    /* renamed from: c  reason: collision with root package name */
    public RestUrlConnectionRequest f28552c;

    /* renamed from: d  reason: collision with root package name */
    public URLConnection f28553d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28554e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28555f;

    /* loaded from: classes7.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public b(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28555f = false;
        this.a = context.getApplicationContext();
        this.f28551b = str;
        this.f28555f = z;
    }

    @Override // c.f.a.g.d.c
    public e a(c.f.a.g.d.d dVar) throws MalformedURLException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            this.f28552c = (RestUrlConnectionRequest) dVar;
            String b2 = dVar.b();
            if (this.f28552c.k()) {
                b2 = d(b2);
            }
            URL url = new URL(b2);
            this.f28553d = url.openConnection();
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                if (RestDebugConfig.getInstance().isQAEnv()) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, new TrustManager[]{new c.f.a.g.d.h.a()}, null);
                    ((HttpsURLConnection) this.f28553d).setSSLSocketFactory(sSLContext.getSocketFactory());
                    ((HttpsURLConnection) this.f28553d).setHostnameVerifier(new a(this));
                } else {
                    f((HttpsURLConnection) this.f28553d);
                    i((HttpsURLConnection) this.f28553d);
                }
            }
            LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "con url: " + url + ", host: " + this.f28553d.getURL().getHost());
            if (this.f28552c.j()) {
                return b(url);
            }
            if (this.f28552c.k()) {
                return g(url);
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    public final e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, url)) == null) {
            e(this.f28553d);
            h(this.f28553d);
            return c(url, this.f28553d, "POST");
        }
        return (e) invokeL.objValue;
    }

    public final e c(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, url, uRLConnection, str)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            return new d(new BufferedInputStream(uRLConnection.getInputStream()), httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), httpURLConnection.getHeaderFields());
        }
        return (e) invokeLLL.objValue;
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            RestUrlConnectionRequest restUrlConnectionRequest = this.f28552c;
            if (restUrlConnectionRequest != null) {
                String processedParams = restUrlConnectionRequest.getProcessedParams();
                if (TextUtils.isEmpty(processedParams)) {
                    return str;
                }
                if (str.contains("?")) {
                    return str + "&" + processedParams;
                }
                return str + "?" + processedParams;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void e(URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uRLConnection) == null) {
            if (this.f28554e) {
                uRLConnection.setConnectTimeout(this.f28552c.i() > 0 ? this.f28552c.i() : 30000);
                uRLConnection.setReadTimeout(this.f28552c.i() > 0 ? this.f28552c.i() : 30000);
            } else {
                uRLConnection.setConnectTimeout(this.f28552c.i() > 0 ? this.f28552c.i() : 30000);
                uRLConnection.setReadTimeout(this.f28552c.i() > 0 ? this.f28552c.i() : 30000);
            }
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            } else {
                System.setProperty("http.keepAlive", "true");
                System.setProperty("http.maxConnections ", String.valueOf(10));
                System.setProperty("sun.net.http.errorstream.enableBuffering", "true");
            }
            if (j()) {
                uRLConnection.setRequestProperty("User-Agent", "");
                uRLConnection.setRequestProperty("Accept-Encoding", "");
                return;
            }
            uRLConnection.setRequestProperty("User-Agent", this.f28551b);
            for (Map.Entry<String, List<String>> entry : this.f28552c.a().entrySet()) {
                uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
            }
            if (this.f28555f) {
                k();
            }
        }
    }

    public final void f(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, httpsURLConnection) == null) {
            try {
                c.f.a.b.b bVar = new c.f.a.b.b(c.f.a.b.a.a().b(httpsURLConnection.getURL().getHost()));
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{bVar}, null);
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (KeyManagementException unused) {
                throw new IllegalStateException("Should never happen");
            } catch (NoSuchAlgorithmException unused2) {
                throw new IllegalStateException("Should never happen");
            }
        }
    }

    public final e g(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, url)) == null) {
            e(this.f28553d);
            return c(url, this.f28553d, "GET");
        }
        return (e) invokeL.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0061 -> B:40:0x0070). Please submit an issue!!! */
    public final void h(URLConnection uRLConnection) {
        RestUrlConnectionRequest restUrlConnectionRequest;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uRLConnection) == null) || (restUrlConnectionRequest = this.f28552c) == null) {
            return;
        }
        String processedParams = restUrlConnectionRequest.getProcessedParams();
        RestMultipartEntity g2 = this.f28552c.g();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        if (g2 != null) {
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + g2.a());
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                try {
                    dataOutputStream = new DataOutputStream(uRLConnection.getOutputStream());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            dataOutputStream.writeBytes(processedParams);
            if (g2 != null) {
                g2.b(dataOutputStream);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException e4) {
            e = e4;
            dataOutputStream2 = dataOutputStream;
            e.printStackTrace();
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public final void i(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, httpsURLConnection) == null) || httpsURLConnection == null) {
            return;
        }
        httpsURLConnection.setHostnameVerifier(c.f.a.g.d.a.a);
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f28552c != null) {
                a.InterfaceC1580a a2 = c.f.a.g.a.a();
                String f2 = this.f28552c.f();
                return (TextUtils.isEmpty(f2) || a2 == null || !a2.a(f2)) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.a.getDir("appcache", 0), "http"), 10485760L);
            } catch (Exception unused) {
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // c.f.a.g.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            URLConnection uRLConnection = this.f28553d;
            if (uRLConnection != null) {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
                this.f28553d = null;
            }
            if (this.f28555f) {
                l();
            }
        }
    }
}
