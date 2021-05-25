package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class b implements com.baidu.fsg.base.restnet.rest.b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5101a = "appcache";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5102b = 2;

    /* renamed from: c  reason: collision with root package name */
    public Context f5103c;

    /* renamed from: d  reason: collision with root package name */
    public String f5104d;

    /* renamed from: e  reason: collision with root package name */
    public e f5105e;

    /* renamed from: f  reason: collision with root package name */
    public URLConnection f5106f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5107g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5108h;

    public b(Context context, String str, boolean z) {
        this.f5108h = false;
        this.f5103c = context.getApplicationContext();
        this.f5104d = str;
        this.f5108h = z;
    }

    private com.baidu.fsg.base.restnet.rest.e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        URL url2 = new URL(a(url.toString()));
        URLConnection openConnection = url2.openConnection();
        this.f5106f = openConnection;
        a(openConnection);
        return a(url2, this.f5106f, "GET");
    }

    private boolean c() {
        if (this.f5105e != null) {
            RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
            String k = this.f5105e.k();
            return (TextUtils.isEmpty(k) || requestCallback == null || !requestCallback.isSpecialUrl(k)) ? false : true;
        }
        return false;
    }

    private void d() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.f5103c.getDir("appcache", 0), "com/baidu/fsg/base/restnet/http"), Long.valueOf((long) Config.FULL_TRACE_LOG_LIMIT));
        } catch (Exception unused) {
        }
    }

    private void e() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d dVar) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.f5105e = (e) dVar;
        URL url = new URL(dVar.d());
        LogUtil.v("apollon_rest", "con url: " + url + ", host: " + dVar.b().c("Host"));
        if (this.f5105e.i()) {
            return a(url);
        }
        if (this.f5105e.j()) {
            return b(url);
        }
        return null;
    }

    private void b() {
        ((HttpsURLConnection) this.f5106f).setHostnameVerifier(new c(this));
    }

    private void b(URLConnection uRLConnection) {
        DataOutputStream dataOutputStream;
        e eVar = this.f5105e;
        if (eVar != null) {
            String l = eVar.l();
            RestMultipartEntity a2 = this.f5105e.a();
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
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
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

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void a() {
        URLConnection uRLConnection = this.f5106f;
        if (uRLConnection != null) {
            if (uRLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) uRLConnection).disconnect();
            } else if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            this.f5106f = null;
        }
        if (this.f5108h) {
            e();
        }
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        URLConnection openConnection = url.openConnection();
        this.f5106f = openConnection;
        a(openConnection);
        b(this.f5106f);
        return a(url, this.f5106f, "POST");
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        Map<String, List<String>> headerFields = uRLConnection.getHeaderFields();
        return new f(new BufferedInputStream(uRLConnection.getInputStream()), responseCode, httpURLConnection.getResponseMessage(), headerFields);
    }

    private void a(URLConnection uRLConnection) {
        if (this.f5107g) {
            uRLConnection.setConnectTimeout(this.f5105e.h() > 0 ? this.f5105e.h() : 30000);
            uRLConnection.setReadTimeout(this.f5105e.h() > 0 ? this.f5105e.h() : 30000);
        } else {
            uRLConnection.setConnectTimeout(this.f5105e.h() > 0 ? this.f5105e.h() : 30000);
            uRLConnection.setReadTimeout(this.f5105e.h() > 0 ? this.f5105e.h() : 30000);
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
        } else {
            uRLConnection.setRequestProperty("User-Agent", this.f5104d);
            for (Map.Entry<String, List<String>> entry : this.f5105e.b().entrySet()) {
                uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
            }
            if (this.f5108h) {
                d();
            }
        }
        if (!(this.f5106f instanceof HttpsURLConnection) || com.baidu.fsg.base.c.a().a()) {
            return;
        }
        b();
    }

    private String a(String str) {
        e eVar = this.f5105e;
        if (eVar != null) {
            String l = eVar.l();
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
}
