package com.baidu.clientupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.clientupdate.a.d;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.d.j;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.util.LogUtil;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ClientUpdater {

    /* renamed from: e  reason: collision with root package name */
    public static ClientUpdater f4584e;
    public static Runnable l;
    public static long stime;

    /* renamed from: a  reason: collision with root package name */
    public Context f4585a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f4586b;

    /* renamed from: c  reason: collision with root package name */
    public String f4587c;

    /* renamed from: f  reason: collision with root package name */
    public IClientUpdaterCallback f4589f;

    /* renamed from: g  reason: collision with root package name */
    public IClientUpdaterCallback f4590g;

    /* renamed from: h  reason: collision with root package name */
    public double f4591h;
    public BroadcastReceiver i;
    public IntentFilter j;
    public com.baidu.clientupdate.c.a n;
    public d o;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4588d = false;
    public boolean k = false;
    public Boolean m = Boolean.FALSE;

    public ClientUpdater(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f4585a = applicationContext;
        this.o = d.a(applicationContext);
        if (this.f4586b == null) {
            this.f4586b = new Handler(this.f4585a.getMainLooper());
        }
        if (l == null) {
            l = new a(this);
        }
        this.i = new b(this);
        this.j = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.n = com.baidu.clientupdate.c.a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f4586b == null) {
            return;
        }
        if (j.d(this.f4585a)) {
            LogUtil.logD("ClientUpdater", "应用位于前台，不发起自动检查更新请求;");
        } else if (j.a(this.f4585a)) {
            this.f4586b.removeCallbacks(l);
            LogUtil.logD("ClientUpdater", "延迟20秒，因为有时CONNECTIVITY_CHANGE Action会很频繁");
            this.f4586b.postDelayed(l, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r4 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Exception exc) {
        Log.w("ClientUpdater", exc);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", "4");
            jSONObject.put("messageDetail", exc.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        IClientUpdaterCallback iClientUpdaterCallback = this.f4588d ? this.f4589f : this.f4590g;
        iClientUpdaterCallback.onException(jSONObject);
        com.baidu.clientupdate.d.a.a(this.f4585a).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01a6, code lost:
        if (r0 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HttpURLConnection httpURLConnection, InputStream inputStream, StringBuilder sb) {
        com.baidu.clientupdate.d.a a2;
        IClientUpdaterCallback iClientUpdaterCallback;
        if (httpURLConnection.getResponseCode() != 200) {
            String responseMessage = httpURLConnection.getResponseMessage();
            d dVar = this.o;
            String c2 = this.n.c();
            String b2 = this.n.b();
            dVar.a(c2, "0", b2, "a3", "1", (System.currentTimeMillis() / 1000) + "", "", "sendUpdateRequest", responseMessage);
            LogUtil.logD("ClientUpdater", "更新请求失败：  " + responseMessage);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msgId", "3");
                jSONObject.put("messageDetail", responseMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            IClientUpdaterCallback iClientUpdaterCallback2 = this.f4588d ? this.f4589f : this.f4590g;
            iClientUpdaterCallback2.onError(jSONObject);
            com.baidu.clientupdate.d.a.a(this.f4585a).c();
            return;
        }
        d dVar2 = this.o;
        String c3 = this.n.c();
        String b3 = this.n.b();
        dVar2.a(c3, "0", b3, "a3", "0", (System.currentTimeMillis() / 1000) + "", "", "sendUpdateRequest", "");
        InputStream inputStream2 = httpURLConnection.getInputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream2.read(bArr);
            if (read == -1) {
                break;
            }
            sb.append(new String(bArr, 0, read, "utf-8"));
        }
        inputStream2.close();
        LogUtil.logD("ClientUpdater", "更新请求后的返回结果: " + sb.toString());
        JSONObject jSONObject2 = new JSONObject(sb.toString());
        String optString = jSONObject2.optString("status");
        if (!TextUtils.isEmpty(optString) && Integer.valueOf(optString).intValue() == 1) {
            d dVar3 = this.o;
            String c4 = this.n.c();
            String b4 = this.n.b();
            dVar3.a(c4, "0", b4, "a4", "0", (System.currentTimeMillis() / 1000) + "", "", "haveUpdate", "");
        } else if (!TextUtils.isEmpty(optString) && Integer.valueOf(optString).intValue() == 0) {
            d dVar4 = this.o;
            String c5 = this.n.c();
            String b5 = this.n.b();
            dVar4.a(c5, "0", b5, "a4", "0", (System.currentTimeMillis() / 1000) + "", "", "notUpdate", "");
        }
        if (this.f4588d) {
            this.f4589f.onFetched(jSONObject2);
            a2 = com.baidu.clientupdate.d.a.a(this.f4585a);
            iClientUpdaterCallback = this.f4589f;
        } else {
            IClientUpdaterCallback iClientUpdaterCallback3 = this.f4590g;
            if (iClientUpdaterCallback3 == null) {
                return;
            }
            iClientUpdaterCallback3.onFetched(jSONObject2);
            a2 = com.baidu.clientupdate.d.a.a(this.f4585a);
            iClientUpdaterCallback = this.f4590g;
        }
        a2.a(jSONObject2, iClientUpdaterCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f4588d = true;
        long currentTimeMillis = System.currentTimeMillis();
        LogUtil.logD("ClientUpdater", "接收到网络状态的变化，检测上次更新时间");
        LogUtil.logD("ClientUpdater", "设置的检查更新的间隔时间： " + ((long) (this.f4591h * 3600000.0d)) + "ms");
        StringBuilder sb = new StringBuilder();
        sb.append("当前时间：");
        sb.append(currentTimeMillis);
        LogUtil.logD("ClientUpdater", sb.toString());
        LogUtil.logD("ClientUpdater", "上次检查更新时间： " + j.c(this.f4585a));
        if (currentTimeMillis - j.c(this.f4585a) <= ((long) (this.f4591h * 3600000.0d))) {
            LogUtil.logD("ClientUpdater", "离上一次更新检查的时间小于设置的时间间隔，不检查更新 ");
            return;
        }
        LogUtil.logD("ClientUpdater", "大于设置的时间间隔，当前存在网络连接时进行更新检查 ");
        if (j.a(this.f4585a)) {
            new c(this).start();
            return;
        }
        StringBuilder sb2 = new StringBuilder("当前网络不可用!");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", "2");
            jSONObject.put("messageDetail", sb2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f4589f.onError(jSONObject);
        LogUtil.logD("ClientUpdater", "当前网络不可用! ");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF, IF, INVOKE, INVOKE, IF, INVOKE, INVOKE, IF, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c7, code lost:
        if (r4 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ca, code lost:
        if (r6 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cc, code lost:
        if (r7 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ce, code lost:
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d0, code lost:
        r0 = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
        r0.load(null, null);
        r0.setCertificateEntry("ca1", r6);
        r0.setCertificateEntry("ca2", r7);
        r0.setCertificateEntry("ca3", r1);
        r1 = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
        r1.init(r0);
        r0 = javax.net.ssl.SSLContext.getInstance("TLS");
        r0.init(null, r1.getTrustManagers(), null);
        r1 = new java.lang.StringBuilder();
        r2 = (javax.net.ssl.HttpsURLConnection) new java.net.URL(r10.f4587c).openConnection();
        r2.setSSLSocketFactory(r0.getSocketFactory());
        r2.setConnectTimeout(5000);
        r2.setReadTimeout(5000);
        r2.connect();
        a(r2, null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0129, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Certificate certificate;
        Certificate certificate2;
        Certificate certificate3;
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream open = this.f4585a.getResources().getAssets().open("LCUpdate/ca-globalsign-nv-sa.pem");
        InputStream open2 = this.f4585a.getResources().getAssets().open("LCUpdate/ca-verisign-class-3-public-primary-certification-authority-en.pem");
        InputStream open3 = this.f4585a.getResources().getAssets().open("LCUpdate/ca-verisign-class-3-public-primary-certification-authority-g5-en.pem");
        try {
            try {
                certificate2 = certificateFactory.generateCertificate(open);
                try {
                    LogUtil.logD("ClientUpdater", "ca1=" + ((X509Certificate) certificate2).getSubjectDN());
                    certificate3 = certificateFactory.generateCertificate(open2);
                    try {
                        LogUtil.logD("ClientUpdater", "ca2=" + ((X509Certificate) certificate3).getSubjectDN());
                        certificate = certificateFactory.generateCertificate(open3);
                    } catch (Exception e2) {
                        e = e2;
                        certificate = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    certificate = null;
                    certificate3 = null;
                }
                try {
                    LogUtil.logD("ClientUpdater", "ca3=" + ((X509Certificate) certificate).getSubjectDN());
                } catch (Exception e4) {
                    e = e4;
                    LogUtil.logE("ClientUpdater", Log.getStackTraceString(e));
                    if (open != null) {
                        open.close();
                    }
                    if (open2 != null) {
                        open2.close();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                certificate = null;
                certificate2 = null;
                certificate3 = null;
            }
        } finally {
            if (open != null) {
                open.close();
            }
            if (open2 != null) {
                open2.close();
            }
            if (open3 != null) {
                open3.close();
            }
        }
    }

    public static InputStream getCAInputStream(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection.getInputStream();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.logE("ClientUpdater", "getCAInputStream fail. ");
            return null;
        }
    }

    public static synchronized ClientUpdater getInstance(Context context) {
        ClientUpdater clientUpdater;
        synchronized (ClientUpdater.class) {
            if (f4584e == null) {
                f4584e = new ClientUpdater(context);
            }
            clientUpdater = f4584e;
        }
        return clientUpdater;
    }

    public static void release() {
        synchronized (ClientUpdater.class) {
            if (f4584e != null) {
                f4584e.f4590g = null;
                f4584e.f4589f = null;
                f4584e.n = null;
                l = null;
                com.baidu.clientupdate.d.a.e();
                f4584e = null;
            }
        }
    }

    public void addParamValue(String str, String str2) {
        this.n.a(str, str2);
    }

    public void appLaunchedCheckUpdate(IClientUpdaterCallback iClientUpdaterCallback) {
        this.k = true;
        checkUpdate(iClientUpdaterCallback);
    }

    public void cancelAutoCheckUpdate() {
        this.f4588d = false;
        if (this.m.booleanValue()) {
            this.f4585a.unregisterReceiver(this.i);
        }
        this.m = Boolean.FALSE;
    }

    public void cancelDownload(long j) {
        DownloadManager.getInstance(this.f4585a).cancel(j);
    }

    public void checkUpdate(double d2, IClientUpdaterCallback iClientUpdaterCallback) {
        if (d2 <= 0.0d || iClientUpdaterCallback == null) {
            d dVar = this.o;
            String c2 = this.n.c();
            String b2 = this.n.b();
            dVar.a(c2, "0", b2, "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "autocheckUpdate", "intervalHour < 0 or clientUpdaterCallback=null");
            LogUtil.logE("ClientUpdater", "intervalHour < 0 或者 clientUpdaterCallback为null或者JSONObject为null");
            return;
        }
        this.f4589f = iClientUpdaterCallback;
        this.f4591h = d2;
        try {
        } catch (Exception e2) {
            d dVar2 = this.o;
            String c3 = this.n.c();
            String b3 = this.n.b();
            dVar2.a(c3, "0", b3, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "autoCheckUpdate", e2.toString());
        }
        if (!j.b(this.f4585a)) {
            StringBuilder sb = new StringBuilder("请加入权限：ACCESS_NETWORK_STATE、INTERNET、GET_TASKS");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgId", "1");
            jSONObject.put("messageDetail", sb.toString());
            this.f4589f.onError(jSONObject);
            return;
        }
        d dVar3 = this.o;
        String c4 = this.n.c();
        String b4 = this.n.b();
        dVar3.a(c4, "0", b4, "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "autoCheckUpdate", "");
        this.f4585a.registerReceiver(this.i, this.j);
        this.m = Boolean.TRUE;
    }

    public void checkUpdate(IClientUpdaterCallback iClientUpdaterCallback) {
        stime = System.currentTimeMillis();
        if (iClientUpdaterCallback == null) {
            d dVar = this.o;
            String c2 = this.n.c();
            String b2 = this.n.b();
            dVar.a(c2, "0", b2, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "clientUpdaterCallback=null");
            LogUtil.logE("ClientUpdater", " clientUpdaterCallback为null或者JSONObject为null");
            return;
        }
        try {
            this.f4590g = iClientUpdaterCallback;
        } catch (Exception e2) {
            d dVar2 = this.o;
            String c3 = this.n.c();
            String b3 = this.n.b();
            dVar2.a(c3, "0", b3, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", e2.toString());
        }
        if (!j.b(this.f4585a)) {
            StringBuilder sb = new StringBuilder("请加入权限：ACCESS_NETWORK_STATE、INTERNET");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgId", "1");
            jSONObject.put("messageDetail", sb.toString());
            if (this.f4590g != null) {
                this.f4590g.onError(jSONObject);
            }
        } else if (!j.a(this.f4585a)) {
            StringBuilder sb2 = new StringBuilder("当前网络不可用!");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msgId", "2");
            jSONObject2.put("messageDetail", sb2.toString());
            if (this.f4590g != null) {
                this.f4590g.onError(jSONObject2);
            }
        } else {
            d dVar3 = this.o;
            String c4 = this.n.c();
            String b4 = this.n.b();
            dVar3.a(c4, "0", b4, "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "");
            this.f4588d = false;
            new c(this).start();
        }
    }

    public void deleteDownload(long j) {
        DownloadManager.getInstance(this.f4585a).delete(j);
    }

    public void launchSystemInstalller(String str, Download download) {
        try {
            DownloadManager.getInstance(this.f4585a).launchSystemInstalller(str, download);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public ClientUpdateInfo parseClientUpdateInfo(JSONObject jSONObject) {
        return com.baidu.clientupdate.d.a.a(this.f4585a).a(jSONObject);
    }

    public RuleInfo parseRule(JSONObject jSONObject) {
        return com.baidu.clientupdate.d.a.a(this.f4585a).b(jSONObject);
    }

    public void pauseDownload(long j) {
        DownloadManager.getInstance(this.f4585a).pause(j);
    }

    public void resumeDownload(long j) {
        DownloadManager.getInstance(this.f4585a).resume(j);
    }

    public void setCfrom(String str) {
        this.n.j(str);
    }

    public void setContext(Context context) {
        this.f4585a = context;
    }

    public void setDownloadPublicKey(boolean z) {
        DownloadManager.getInstance(this.f4585a).setDownloadPublicKey(z);
    }

    public void setFileProvider(String str) {
        j.a(str);
    }

    public void setFrom(String str) {
        this.n.h(str);
    }

    public void setIgnore(String str) {
        this.n.k(str);
    }

    public void setOSPlatform(String str) {
        try {
            com.baidu.clientupdate.c.a.a(this.f4585a).a(str);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public void setOsBranch(String str) {
        this.n.i(str);
    }

    public void setOsName(String str) {
        this.n.f(str);
    }

    public void setTime(String str) {
        this.n.l(str);
    }

    public void setTypeId(String str) {
        this.n.g(str);
    }

    public void setUseCFG(boolean z) {
        com.baidu.clientupdate.c.a.a(this.f4585a).a(z);
    }

    public void setUseRSA(boolean z) {
        DownloadManager.getInstance(this.f4585a).setUseRSA(z);
    }

    public void setVersionCode(String str) {
        this.n.e(str);
    }

    public void setVersionName(String str) {
        this.n.d(str);
    }

    public void startDownload(ClientUpdateInfo clientUpdateInfo, String str) {
        try {
            com.baidu.clientupdate.d.a.a(this.f4585a).b(clientUpdateInfo, str);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public void startDownload(ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        try {
            com.baidu.clientupdate.d.a.a(this.f4585a).a(clientUpdateInfo, str, z);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public void startPatchDownload(ClientUpdateInfo clientUpdateInfo, String str) {
        try {
            com.baidu.clientupdate.d.a.a(this.f4585a).a(clientUpdateInfo, str);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public void throwError(JSONObject jSONObject) {
        IClientUpdaterCallback iClientUpdaterCallback;
        try {
            if (this.f4588d) {
                iClientUpdaterCallback = this.f4589f;
            } else if (this.f4590g == null) {
                return;
            } else {
                iClientUpdaterCallback = this.f4590g;
            }
            iClientUpdaterCallback.onError(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
