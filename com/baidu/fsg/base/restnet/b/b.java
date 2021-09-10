package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
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
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public class b implements com.baidu.fsg.base.restnet.rest.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39374a = "appcache";

    /* renamed from: b  reason: collision with root package name */
    public static final int f39375b = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f39376c;

    /* renamed from: d  reason: collision with root package name */
    public String f39377d;

    /* renamed from: e  reason: collision with root package name */
    public d f39378e;

    /* renamed from: f  reason: collision with root package name */
    public URLConnection f39379f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39380g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39381h;

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
        this.f39381h = false;
        this.f39376c = context.getApplicationContext();
        this.f39377d = str;
        this.f39381h = z;
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, url)) == null) {
            URLConnection openConnection = url.openConnection();
            this.f39379f = openConnection;
            a(openConnection);
            b(this.f39379f);
            return a(url, this.f39379f, "POST");
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, url, uRLConnection, str)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            return new e(new BufferedInputStream(uRLConnection.getInputStream()), httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), uRLConnection.getHeaderFields());
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeLLL.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            d dVar = this.f39378e;
            if (dVar != null) {
                String l = dVar.l();
                if (TextUtils.isEmpty(l)) {
                    return str;
                }
                if (str.contains("?")) {
                    return str + "&" + l;
                }
                return str + "?" + l;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r4.f39378e.h() > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r4.f39378e.h() > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        r1 = r4.f39378e.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, uRLConnection) == null) {
            int i2 = 30000;
            if (this.f39380g) {
                uRLConnection.setConnectTimeout(this.f39378e.h() > 0 ? this.f39378e.h() : 30000);
            } else {
                uRLConnection.setConnectTimeout(this.f39378e.h() > 0 ? this.f39378e.h() : 30000);
            }
            uRLConnection.setReadTimeout(i2);
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
            } else {
                uRLConnection.setRequestProperty("User-Agent", this.f39377d);
                for (Map.Entry<String, List<String>> entry : this.f39378e.b().entrySet()) {
                    uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
                }
                if (this.f39381h) {
                    d();
                }
            }
            if (!(this.f39379f instanceof HttpsURLConnection) || com.baidu.fsg.base.b.a().a()) {
                return;
            }
            b();
        }
    }

    private com.baidu.fsg.base.restnet.rest.e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, url)) == null) {
            URL url2 = new URL(a(url.toString()));
            URLConnection openConnection = url2.openConnection();
            this.f39379f = openConnection;
            a(openConnection);
            return a(url2, this.f39379f, "GET");
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ((HttpsURLConnection) this.f39379f).setHostnameVerifier(new HostnameVerifier(this) { // from class: com.baidu.fsg.base.restnet.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f39382a;

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
                    this.f39382a = this;
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                        try {
                            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                            String v = this.f39382a.f39378e.b().v();
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

    private void b(URLConnection uRLConnection) {
        d dVar;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, uRLConnection) == null) || (dVar = this.f39378e) == null) {
            return;
        }
        String l = dVar.l();
        RestMultipartEntity a2 = this.f39378e.a();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        if (a2 != null) {
            ((HttpURLConnection) uRLConnection).setFixedLengthStreamingMode((int) a2.getContentLength());
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + a2.getBoundary());
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                try {
                    dataOutputStream = new DataOutputStream(uRLConnection.getOutputStream());
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeBytes(l);
                if (a2 != null) {
                    a2.writeTo(dataOutputStream);
                }
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (IOException e3) {
                e = e3;
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
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.f39378e != null) {
                RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
                String k = this.f39378e.k();
                return (TextUtils.isEmpty(k) || requestCallback == null || !requestCallback.isSpecialUrl(k)) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.f39376c.getDir("appcache", 0), "com/baidu/fsg/base/restnet/http"), 10485760L);
            } catch (Exception unused) {
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d dVar) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            this.f39378e = (d) dVar;
            URL url = new URL(dVar.d());
            LogUtil.v("apollon_rest", "con url: " + url + ", host: " + dVar.b().c("Host"));
            if (this.f39378e.i()) {
                return a(url);
            }
            if (this.f39378e.j()) {
                return b(url);
            }
            return null;
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            URLConnection uRLConnection = this.f39379f;
            if (uRLConnection != null) {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
                this.f39379f = null;
            }
            if (this.f39381h) {
                e();
            }
        }
    }
}
