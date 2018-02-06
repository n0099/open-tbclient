package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.restnet.RestDebugConfig;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.utils.LogUtil;
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
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c implements com.baidu.fsg.base.restnet.rest.b {
    private static final String a = "appcache";
    private static final int b = 2;
    private Context c;
    private String d;
    private f e;
    private URLConnection f;
    private boolean g;
    private boolean h;

    public c(Context context, String str, boolean z) {
        this.h = false;
        this.c = context.getApplicationContext();
        this.d = str;
        this.h = z;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d dVar) throws MalformedURLException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.e = (f) dVar;
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
        Map<String, List<String>> headerFields = ((HttpURLConnection) uRLConnection).getHeaderFields();
        return new g(new BufferedInputStream(uRLConnection.getInputStream()), responseCode, ((HttpURLConnection) uRLConnection).getResponseMessage(), headerFields);
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
            uRLConnection.setRequestProperty(HTTP.USER_AGENT, "");
            uRLConnection.setRequestProperty("Accept-Encoding", "");
        } else {
            uRLConnection.setRequestProperty(HTTP.USER_AGENT, this.d);
            for (Map.Entry<String, List<String>> entry : this.e.b().entrySet()) {
                uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
            }
            if (this.h) {
                d();
            }
        }
        if (this.f instanceof HttpsURLConnection) {
            if (RestDebugConfig.getInstance().isQAEnv()) {
                a.a();
            } else {
                b();
            }
        }
    }

    private void b() {
        ((HttpsURLConnection) this.f).setHostnameVerifier(new d(this));
    }

    private boolean c() {
        if (this.e != null) {
            RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
            String k = this.e.k();
            return (TextUtils.isEmpty(k) || requestCallback == null || !requestCallback.isSpecialUrl(k)) ? false : true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [334=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0074 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.io.DataOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(URLConnection uRLConnection) {
        DataOutputStream dataOutputStream;
        if (this.e == null) {
            return;
        }
        String l = this.e.l();
        f fVar = this.e;
        RestMultipartEntity a2 = fVar.a();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        DataOutputStream dataOutputStream2 = fVar;
        if (a2 != null) {
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + a2.getBoundary());
            dataOutputStream2 = "Content-Type";
        }
        try {
            try {
                dataOutputStream = new DataOutputStream(uRLConnection.getOutputStream());
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
                if (dataOutputStream2 != 0) {
                    try {
                        dataOutputStream2.close();
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
            dataOutputStream2 = 0;
            if (dataOutputStream2 != 0) {
            }
            throw th;
        }
    }

    private String a(String str) {
        if (this.e != null) {
            String l = this.e.l();
            if (!TextUtils.isEmpty(l)) {
                if (str.contains("?")) {
                    return str + "&" + l;
                }
                return str + "?" + l;
            }
            return str;
        }
        return str;
    }

    private void d() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.c.getDir(a, 0), "com/baidu/fsg/base/restnet/http"), 10485760L);
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
