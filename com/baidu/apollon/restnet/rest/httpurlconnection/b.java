package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.a;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
/* loaded from: classes.dex */
public class b implements com.baidu.apollon.restnet.rest.c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3930e = "appcache";

    /* renamed from: h  reason: collision with root package name */
    public static final int f3931h = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3932a;

    /* renamed from: b  reason: collision with root package name */
    public String f3933b;

    /* renamed from: c  reason: collision with root package name */
    public RestUrlConnectionRequest f3934c;

    /* renamed from: d  reason: collision with root package name */
    public URLConnection f3935d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3936f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3937g;

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
        this.f3937g = false;
        this.f3932a = context.getApplicationContext();
        this.f3933b = str;
        this.f3937g = z;
    }

    private e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, url)) == null) {
            a(this.f3935d);
            return a(url, this.f3935d, "GET");
        }
        return (e) invokeL.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.f3934c != null) {
                a.InterfaceC0064a a2 = com.baidu.apollon.restnet.a.a();
                String h2 = this.f3934c.h();
                return (TextUtils.isEmpty(h2) || a2 == null || !a2.a(h2)) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.f3932a.getDir("appcache", 0), "http"), Long.valueOf((long) Config.FULL_TRACE_LOG_LIMIT));
            } catch (Exception unused) {
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.apollon.restnet.rest.c
    public e a(com.baidu.apollon.restnet.rest.d dVar) throws MalformedURLException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            this.f3934c = (RestUrlConnectionRequest) dVar;
            String c2 = dVar.c();
            if (this.f3934c.k()) {
                c2 = a(c2);
            }
            URL url = new URL(c2);
            this.f3935d = url.openConnection();
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                if (RestDebugConfig.getInstance().isQAEnv()) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, new TrustManager[]{new a()}, null);
                    ((HttpsURLConnection) this.f3935d).setSSLSocketFactory(sSLContext.getSocketFactory());
                    ((HttpsURLConnection) this.f3935d).setHostnameVerifier(new HostnameVerifier(this) { // from class: com.baidu.apollon.restnet.rest.httpurlconnection.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ b f3938a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f3938a = this;
                        }

                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str, SSLSession sSLSession) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                                return true;
                            }
                            return invokeLL.booleanValue;
                        }
                    });
                } else {
                    a((HttpsURLConnection) this.f3935d);
                    b((HttpsURLConnection) this.f3935d);
                }
            }
            LogUtil.v("apollon_rest", "con url: " + url + ", host: " + this.f3935d.getURL().getHost());
            if (this.f3934c.j()) {
                return a(url);
            }
            if (this.f3934c.k()) {
                return b(url);
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ((HttpsURLConnection) this.f3935d).setHostnameVerifier(new HostnameVerifier(this) { // from class: com.baidu.apollon.restnet.rest.httpurlconnection.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f3939a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3939a = this;
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                        try {
                            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                            String v = this.f3939a.f3934c.a().v();
                            if (!TextUtils.isEmpty(v) && peerCertificates != null && peerCertificates.length > 0) {
                                X509Certificate x509Certificate = (X509Certificate) peerCertificates[0];
                                Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                                if (subjectAlternativeNames != null) {
                                    for (List<?> list : subjectAlternativeNames) {
                                        if (((Integer) list.get(0)).intValue() == 2) {
                                            String str2 = (String) list.get(1);
                                            if (v.equals(str2)) {
                                                return true;
                                            }
                                            if (str2 != null && str2.startsWith("*") && Pattern.compile(str2.replace("*", "(\\w*-*\\w*)")).matcher(v).matches()) {
                                                return true;
                                            }
                                        }
                                    }
                                } else {
                                    String name = x509Certificate.getSubjectDN().getName();
                                    if (!TextUtils.isEmpty(name) && name.contains("CN=")) {
                                        int indexOf = name.indexOf("CN=") + 3;
                                        int indexOf2 = name.indexOf(",", indexOf);
                                        if (v.equals(indexOf2 > indexOf ? name.substring(indexOf, indexOf2) : name.substring(indexOf))) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        } catch (CertificateParsingException e2) {
                            e2.printStackTrace();
                        } catch (SSLPeerUnverifiedException e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    private void b(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, httpsURLConnection) == null) || httpsURLConnection == null) {
            return;
        }
        httpsURLConnection.setHostnameVerifier(com.baidu.apollon.restnet.rest.a.f3900a);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0061 -> B:40:0x0070). Please submit an issue!!! */
    private void b(URLConnection uRLConnection) {
        RestUrlConnectionRequest restUrlConnectionRequest;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, uRLConnection) == null) || (restUrlConnectionRequest = this.f3934c) == null) {
            return;
        }
        String processedParams = restUrlConnectionRequest.getProcessedParams();
        RestMultipartEntity i2 = this.f3934c.i();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        if (i2 != null) {
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + i2.a());
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
            if (i2 != null) {
                i2.a(dataOutputStream);
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

    @Override // com.baidu.apollon.restnet.rest.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            URLConnection uRLConnection = this.f3935d;
            if (uRLConnection != null) {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
                this.f3935d = null;
            }
            if (this.f3937g) {
                e();
            }
        }
    }

    private e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, url)) == null) {
            a(this.f3935d);
            b(this.f3935d);
            return a(url, this.f3935d, "POST");
        }
        return (e) invokeL.objValue;
    }

    private e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, url, uRLConnection, str)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            return new d(new BufferedInputStream(uRLConnection.getInputStream()), httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), httpURLConnection.getHeaderFields());
        }
        return (e) invokeLLL.objValue;
    }

    private void a(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, httpsURLConnection) == null) {
            try {
                com.baidu.apollon.b.b bVar = new com.baidu.apollon.b.b(com.baidu.apollon.b.a.a().a(httpsURLConnection.getURL().getHost()));
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

    private void a(URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, uRLConnection) == null) {
            if (this.f3936f) {
                uRLConnection.setConnectTimeout(this.f3934c.g() > 0 ? this.f3934c.g() : 30000);
                uRLConnection.setReadTimeout(this.f3934c.g() > 0 ? this.f3934c.g() : 30000);
            } else {
                uRLConnection.setConnectTimeout(this.f3934c.g() > 0 ? this.f3934c.g() : 30000);
                uRLConnection.setReadTimeout(this.f3934c.g() > 0 ? this.f3934c.g() : 30000);
            }
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            } else {
                System.setProperty("http.keepAlive", "true");
                System.setProperty("http.maxConnections ", String.valueOf(10));
                System.setProperty("sun.net.http.errorstream.enableBuffering", "true");
            }
            if (c()) {
                uRLConnection.setRequestProperty("User-Agent", "");
                uRLConnection.setRequestProperty("Accept-Encoding", "");
                return;
            }
            uRLConnection.setRequestProperty("User-Agent", this.f3933b);
            for (Map.Entry<String, List<String>> entry : this.f3934c.a().entrySet()) {
                uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
            }
            if (this.f3937g) {
                d();
            }
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            RestUrlConnectionRequest restUrlConnectionRequest = this.f3934c;
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
}
