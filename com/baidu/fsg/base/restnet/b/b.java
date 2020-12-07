package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
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
/* loaded from: classes16.dex */
public class b implements com.baidu.fsg.base.restnet.rest.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1466a = "appcache";
    private static final int b = 2;
    private Context c;
    private String d;
    private e e;
    private URLConnection f;
    private boolean g;
    private boolean h;

    public b(Context context, String str, boolean z) {
        this.h = false;
        this.c = context.getApplicationContext();
        this.d = str;
        this.h = z;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d dVar) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.e = (e) dVar;
        URL url = new URL(dVar.d());
        LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "con url: " + url + ", host: " + dVar.b().c("Host"));
        if (this.e.i()) {
            return a(url);
        }
        if (this.e.j()) {
            return b(url);
        }
        return null;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void a() {
        if (this.f != null) {
            if (this.f instanceof HttpsURLConnection) {
                ((HttpsURLConnection) this.f).disconnect();
            } else if (this.f instanceof HttpURLConnection) {
                ((HttpURLConnection) this.f).disconnect();
            }
            this.f = null;
        }
        if (this.h) {
            e();
        }
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        this.f = url.openConnection();
        a(this.f);
        b(this.f);
        return a(url, this.f, "POST");
    }

    private com.baidu.fsg.base.restnet.rest.e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        URL url2 = new URL(a(url.toString()));
        this.f = url2.openConnection();
        a(this.f);
        return a(url2, this.f, "GET");
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        int responseCode = ((HttpURLConnection) uRLConnection).getResponseCode();
        Map<String, List<String>> headerFields = uRLConnection.getHeaderFields();
        return new f(new BufferedInputStream(uRLConnection.getInputStream()), responseCode, ((HttpURLConnection) uRLConnection).getResponseMessage(), headerFields);
    }

    private void a(URLConnection uRLConnection) {
        if (this.g) {
            uRLConnection.setConnectTimeout(this.e.h() > 0 ? this.e.h() : 30000);
            uRLConnection.setReadTimeout(this.e.h() > 0 ? this.e.h() : 30000);
        } else {
            uRLConnection.setConnectTimeout(this.e.h() > 0 ? this.e.h() : 30000);
            uRLConnection.setReadTimeout(this.e.h() > 0 ? this.e.h() : 30000);
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
            uRLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "");
        } else {
            uRLConnection.setRequestProperty("User-Agent", this.d);
            for (Map.Entry<String, List<String>> entry : this.e.b().entrySet()) {
                uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
            }
            if (this.h) {
                d();
            }
        }
        if ((this.f instanceof HttpsURLConnection) && !com.baidu.fsg.base.c.a().a()) {
            b();
        }
    }

    private void b() {
        ((HttpsURLConnection) this.f).setHostnameVerifier(new c(this));
    }

    private boolean c() {
        if (this.e != null) {
            RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
            String k = this.e.k();
            return (TextUtils.isEmpty(k) || requestCallback == null || !requestCallback.isSpecialUrl(k)) ? false : true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [331=4] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(URLConnection uRLConnection) {
        DataOutputStream dataOutputStream;
        if (this.e == null) {
            return;
        }
        String l = this.e.l();
        RestMultipartEntity a2 = this.e.a();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        if (a2 != null) {
            ((HttpURLConnection) uRLConnection).setFixedLengthStreamingMode((int) a2.getContentLength());
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + a2.getBoundary());
        }
        try {
            dataOutputStream = new DataOutputStream(uRLConnection.getOutputStream());
            try {
                try {
                    dataOutputStream.writeBytes(l);
                    if (a2 != null) {
                        a2.writeTo(dataOutputStream);
                    }
                    dataOutputStream.flush();
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            dataOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
            if (dataOutputStream != null) {
            }
            throw th;
        }
    }

    private String a(String str) {
        if (this.e != null) {
            String l = this.e.l();
            if (!TextUtils.isEmpty(l)) {
                if (str.contains("?")) {
                    return str + ETAG.ITEM_SEPARATOR + l;
                }
                return str + "?" + l;
            }
            return str;
        }
        return str;
    }

    private void d() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod(Config.INPUT_INSTALLED_PKG, File.class, Long.TYPE).invoke(null, new File(this.c.getDir("appcache", 0), "com/baidu/fsg/base/restnet/http"), 10485760L);
        } catch (Exception e) {
        }
    }

    private void e() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod("close", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
        }
    }
}
