package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.a;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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

    /* renamed from: e  reason: collision with root package name */
    public static final String f3829e = "appcache";

    /* renamed from: h  reason: collision with root package name */
    public static final int f3830h = 2;

    /* renamed from: a  reason: collision with root package name */
    public Context f3831a;

    /* renamed from: b  reason: collision with root package name */
    public String f3832b;

    /* renamed from: c  reason: collision with root package name */
    public RestUrlConnectionRequest f3833c;

    /* renamed from: d  reason: collision with root package name */
    public URLConnection f3834d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3835f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3836g;

    public b(Context context, String str, boolean z) {
        this.f3836g = false;
        this.f3831a = context.getApplicationContext();
        this.f3832b = str;
        this.f3836g = z;
    }

    private e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        a(this.f3834d);
        return a(url, this.f3834d, "GET");
    }

    private boolean c() {
        if (this.f3833c != null) {
            a.InterfaceC0063a a2 = com.baidu.apollon.restnet.a.a();
            String h2 = this.f3833c.h();
            return (TextUtils.isEmpty(h2) || a2 == null || !a2.a(h2)) ? false : true;
        }
        return false;
    }

    private void d() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.f3831a.getDir("appcache", 0), "http"), Long.valueOf((long) Config.FULL_TRACE_LOG_LIMIT));
        } catch (Exception unused) {
        }
    }

    private void e() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.apollon.restnet.rest.c
    public e a(com.baidu.apollon.restnet.rest.d dVar) throws MalformedURLException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.f3833c = (RestUrlConnectionRequest) dVar;
        String c2 = dVar.c();
        if (this.f3833c.k()) {
            c2 = a(c2);
        }
        URL url = new URL(c2);
        this.f3834d = url.openConnection();
        if ("https".equalsIgnoreCase(url.getProtocol())) {
            if (RestDebugConfig.getInstance().isQAEnv()) {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new a()}, null);
                ((HttpsURLConnection) this.f3834d).setSSLSocketFactory(sSLContext.getSocketFactory());
                ((HttpsURLConnection) this.f3834d).setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.apollon.restnet.rest.httpurlconnection.b.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        return true;
                    }
                });
            } else {
                a((HttpsURLConnection) this.f3834d);
                b((HttpsURLConnection) this.f3834d);
            }
        }
        LogUtil.v("apollon_rest", "con url: " + url + ", host: " + this.f3834d.getURL().getHost());
        if (this.f3833c.j()) {
            return a(url);
        }
        if (this.f3833c.k()) {
            return b(url);
        }
        return null;
    }

    private void b() {
        ((HttpsURLConnection) this.f3834d).setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.apollon.restnet.rest.httpurlconnection.b.2
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                try {
                    Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                    String v = b.this.f3833c.a().v();
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
        });
    }

    private void b(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            httpsURLConnection.setHostnameVerifier(com.baidu.apollon.restnet.rest.a.f3800a);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x005d -> B:35:0x006c). Please submit an issue!!! */
    private void b(URLConnection uRLConnection) {
        DataOutputStream dataOutputStream;
        RestUrlConnectionRequest restUrlConnectionRequest = this.f3833c;
        if (restUrlConnectionRequest != null) {
            String processedParams = restUrlConnectionRequest.getProcessedParams();
            RestMultipartEntity i = this.f3833c.i();
            uRLConnection.setDoOutput(true);
            uRLConnection.setDoInput(true);
            if (i != null) {
                uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + i.a());
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
                if (i != null) {
                    i.a(dataOutputStream);
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
    }

    @Override // com.baidu.apollon.restnet.rest.c
    public void a() {
        URLConnection uRLConnection = this.f3834d;
        if (uRLConnection != null) {
            if (uRLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) uRLConnection).disconnect();
            } else if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            this.f3834d = null;
        }
        if (this.f3836g) {
            e();
        }
    }

    private e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        a(this.f3834d);
        b(this.f3834d);
        return a(url, this.f3834d, "POST");
    }

    private e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        return new d(new BufferedInputStream(uRLConnection.getInputStream()), responseCode, httpURLConnection.getResponseMessage(), headerFields);
    }

    private void a(HttpsURLConnection httpsURLConnection) {
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

    private void a(URLConnection uRLConnection) {
        if (this.f3835f) {
            uRLConnection.setConnectTimeout(this.f3833c.g() > 0 ? this.f3833c.g() : 30000);
            uRLConnection.setReadTimeout(this.f3833c.g() > 0 ? this.f3833c.g() : 30000);
        } else {
            uRLConnection.setConnectTimeout(this.f3833c.g() > 0 ? this.f3833c.g() : 30000);
            uRLConnection.setReadTimeout(this.f3833c.g() > 0 ? this.f3833c.g() : 30000);
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
        uRLConnection.setRequestProperty("User-Agent", this.f3832b);
        for (Map.Entry<String, List<String>> entry : this.f3833c.a().entrySet()) {
            uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
        }
        if (this.f3836g) {
            d();
        }
    }

    private String a(String str) {
        RestUrlConnectionRequest restUrlConnectionRequest = this.f3833c;
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
}
