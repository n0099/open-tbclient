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
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public final class ClientUpdater {
    private static ClientUpdater e = null;
    private static Runnable l = null;
    public static long stime;

    /* renamed from: a  reason: collision with root package name */
    private Context f1314a;
    private Handler b;
    private String c;
    private IClientUpdaterCallback f;
    private IClientUpdaterCallback g;
    private double h;
    private BroadcastReceiver i;
    private IntentFilter j;
    private com.baidu.clientupdate.c.a n;
    private d o;
    private boolean d = false;
    private boolean k = false;
    private Boolean m = false;

    private ClientUpdater(Context context) {
        this.f1314a = context.getApplicationContext();
        this.o = d.a(this.f1314a);
        if (this.b == null) {
            this.b = new Handler(this.f1314a.getMainLooper());
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
        if (this.b == null) {
            return;
        }
        if (j.d(this.f1314a)) {
            LogUtil.logD("ClientUpdater", "应用位于前台，不发起自动检查更新请求;");
        } else if (j.a(this.f1314a)) {
            this.b.removeCallbacks(l);
            LogUtil.logD("ClientUpdater", "延迟20秒，因为有时CONNECTIVITY_CHANGE Action会很频繁");
            this.b.postDelayed(l, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Exception exc) {
        Log.w("ClientUpdater", exc);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", "4");
            jSONObject.put("messageDetail", exc.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.d) {
            this.f.onException(jSONObject);
        } else if (this.g != null) {
            this.g.onException(jSONObject);
        }
        com.baidu.clientupdate.d.a.a(this.f1314a).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpURLConnection httpURLConnection, InputStream inputStream, StringBuilder sb) {
        if (httpURLConnection.getResponseCode() != 200) {
            String responseMessage = httpURLConnection.getResponseMessage();
            this.o.a(this.n.c(), "0", this.n.b(), "a3", "1", (System.currentTimeMillis() / 1000) + "", "", "sendUpdateRequest", responseMessage);
            LogUtil.logD("ClientUpdater", "更新请求失败：  " + responseMessage);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msgId", "3");
                jSONObject.put("messageDetail", responseMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.d) {
                this.f.onError(jSONObject);
            } else if (this.g != null) {
                this.g.onError(jSONObject);
            }
            com.baidu.clientupdate.d.a.a(this.f1314a).c();
            return;
        }
        this.o.a(this.n.c(), "0", this.n.b(), "a3", "0", (System.currentTimeMillis() / 1000) + "", "", "sendUpdateRequest", "");
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
        if (jSONObject2 != null) {
            String optString = jSONObject2.optString("status");
            if (!TextUtils.isEmpty(optString) && Integer.valueOf(optString).intValue() == 1) {
                this.o.a(this.n.c(), "0", this.n.b(), "a4", "0", (System.currentTimeMillis() / 1000) + "", "", "haveUpdate", "");
            } else if (!TextUtils.isEmpty(optString) && Integer.valueOf(optString).intValue() == 0) {
                this.o.a(this.n.c(), "0", this.n.b(), "a4", "0", (System.currentTimeMillis() / 1000) + "", "", "notUpdate", "");
            }
        }
        if (this.d) {
            this.f.onFetched(jSONObject2);
            com.baidu.clientupdate.d.a.a(this.f1314a).a(jSONObject2, this.f);
        } else if (this.g != null) {
            this.g.onFetched(jSONObject2);
            com.baidu.clientupdate.d.a.a(this.f1314a).a(jSONObject2, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d = true;
        long currentTimeMillis = System.currentTimeMillis();
        LogUtil.logD("ClientUpdater", "接收到网络状态的变化，检测上次更新时间");
        LogUtil.logD("ClientUpdater", "设置的检查更新的间隔时间： " + ((long) (this.h * 3600000.0d)) + "ms");
        LogUtil.logD("ClientUpdater", "当前时间：" + currentTimeMillis);
        LogUtil.logD("ClientUpdater", "上次检查更新时间： " + j.c(this.f1314a));
        if (currentTimeMillis - j.c(this.f1314a) <= ((long) (this.h * 3600000.0d))) {
            LogUtil.logD("ClientUpdater", "离上一次更新检查的时间小于设置的时间间隔，不检查更新 ");
            return;
        }
        LogUtil.logD("ClientUpdater", "大于设置的时间间隔，当前存在网络连接时进行更新检查 ");
        if (j.a(this.f1314a)) {
            new c(this).start();
            return;
        }
        StringBuilder sb = new StringBuilder("当前网络不可用!");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", "2");
            jSONObject.put("messageDetail", sb.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f.onError(jSONObject);
        LogUtil.logD("ClientUpdater", "当前网络不可用! ");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF, IF, INVOKE, INVOKE, IF, INVOKE, INVOKE, IF, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Certificate certificate;
        Certificate certificate2;
        Certificate certificate3;
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream open = this.f1314a.getResources().getAssets().open("LCUpdate/ca-globalsign-nv-sa.pem");
        InputStream open2 = this.f1314a.getResources().getAssets().open("LCUpdate/ca-verisign-class-3-public-primary-certification-authority-en.pem");
        InputStream open3 = this.f1314a.getResources().getAssets().open("LCUpdate/ca-verisign-class-3-public-primary-certification-authority-g5-en.pem");
        try {
            try {
                certificate3 = certificateFactory.generateCertificate(open);
                try {
                    LogUtil.logD("ClientUpdater", "ca1=" + ((X509Certificate) certificate3).getSubjectDN());
                    certificate2 = certificateFactory.generateCertificate(open2);
                    try {
                        LogUtil.logD("ClientUpdater", "ca2=" + ((X509Certificate) certificate2).getSubjectDN());
                        certificate = certificateFactory.generateCertificate(open3);
                        try {
                            LogUtil.logD("ClientUpdater", "ca3=" + ((X509Certificate) certificate).getSubjectDN());
                        } catch (Exception e2) {
                            e = e2;
                            LogUtil.logE("ClientUpdater", Log.getStackTraceString(e));
                            if (open != null) {
                                open.close();
                            }
                            if (open2 != null) {
                                open2.close();
                            }
                            if (open3 != null) {
                                open3.close();
                            }
                            if (certificate3 != null) {
                                return;
                            }
                            return;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        certificate = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    certificate = null;
                    certificate2 = null;
                }
            } catch (Exception e5) {
                e = e5;
                certificate = null;
                certificate2 = null;
                certificate3 = null;
            }
            if (certificate3 != null || certificate2 == null || certificate == null) {
                return;
            }
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca1", certificate3);
            keyStore.setCertificateEntry("ca2", certificate2);
            keyStore.setCertificateEntry("ca3", certificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            StringBuilder sb = new StringBuilder();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.c).openConnection();
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.setReadTimeout(5000);
            httpsURLConnection.connect();
            a(httpsURLConnection, null, sb);
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
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.logE("ClientUpdater", "getCAInputStream fail. ");
        }
        return null;
    }

    public static synchronized ClientUpdater getInstance(Context context) {
        ClientUpdater clientUpdater;
        synchronized (ClientUpdater.class) {
            if (e == null) {
                e = new ClientUpdater(context);
            }
            clientUpdater = e;
        }
        return clientUpdater;
    }

    public static void release() {
        synchronized (ClientUpdater.class) {
            if (e != null) {
                e.g = null;
                e.f = null;
                e.n = null;
                l = null;
                com.baidu.clientupdate.d.a.e();
                e = null;
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
        this.d = false;
        if (this.m.booleanValue()) {
            this.f1314a.unregisterReceiver(this.i);
        }
        this.m = false;
    }

    public void cancelDownload(long j) {
        DownloadManager.getInstance(this.f1314a).cancel(j);
    }

    public void checkUpdate(double d, IClientUpdaterCallback iClientUpdaterCallback) {
        if (d <= 0.0d || iClientUpdaterCallback == null) {
            this.o.a(this.n.c(), "0", this.n.b(), "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "autocheckUpdate", "intervalHour < 0 or clientUpdaterCallback=null");
            LogUtil.logE("ClientUpdater", "intervalHour < 0 或者 clientUpdaterCallback为null或者JSONObject为null");
            return;
        }
        this.f = iClientUpdaterCallback;
        this.h = d;
        try {
        } catch (Exception e2) {
            this.o.a(this.n.c(), "0", this.n.b(), "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "autoCheckUpdate", e2.toString());
        }
        if (j.b(this.f1314a)) {
            this.o.a(this.n.c(), "0", this.n.b(), "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "autoCheckUpdate", "");
            this.f1314a.registerReceiver(this.i, this.j);
            this.m = true;
            return;
        }
        StringBuilder sb = new StringBuilder("请加入权限：ACCESS_NETWORK_STATE、INTERNET、GET_TASKS");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msgId", "1");
        jSONObject.put("messageDetail", sb.toString());
        this.f.onError(jSONObject);
    }

    public void checkUpdate(IClientUpdaterCallback iClientUpdaterCallback) {
        stime = System.currentTimeMillis();
        if (iClientUpdaterCallback == null) {
            this.o.a(this.n.c(), "0", this.n.b(), "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "clientUpdaterCallback=null");
            LogUtil.logE("ClientUpdater", " clientUpdaterCallback为null或者JSONObject为null");
            return;
        }
        try {
            this.g = iClientUpdaterCallback;
        } catch (Exception e2) {
            this.o.a(this.n.c(), "0", this.n.b(), "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", e2.toString());
        }
        if (!j.b(this.f1314a)) {
            StringBuilder sb = new StringBuilder("请加入权限：ACCESS_NETWORK_STATE、INTERNET");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgId", "1");
            jSONObject.put("messageDetail", sb.toString());
            if (this.g != null) {
                this.g.onError(jSONObject);
            }
        } else if (j.a(this.f1314a)) {
            this.o.a(this.n.c(), "0", this.n.b(), "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "");
            this.d = false;
            new c(this).start();
        } else {
            StringBuilder sb2 = new StringBuilder("当前网络不可用!");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msgId", "2");
            jSONObject2.put("messageDetail", sb2.toString());
            if (this.g != null) {
                this.g.onError(jSONObject2);
            }
        }
    }

    public void deleteDownload(long j) {
        DownloadManager.getInstance(this.f1314a).delete(j);
    }

    public void launchSystemInstalller(String str, Download download) {
        try {
            DownloadManager.getInstance(this.f1314a).launchSystemInstalller(str, download);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public ClientUpdateInfo parseClientUpdateInfo(JSONObject jSONObject) {
        return com.baidu.clientupdate.d.a.a(this.f1314a).a(jSONObject);
    }

    public RuleInfo parseRule(JSONObject jSONObject) {
        return com.baidu.clientupdate.d.a.a(this.f1314a).b(jSONObject);
    }

    public void pauseDownload(long j) {
        DownloadManager.getInstance(this.f1314a).pause(j);
    }

    public void resumeDownload(long j) {
        DownloadManager.getInstance(this.f1314a).resume(j);
    }

    public void setCfrom(String str) {
        this.n.j(str);
    }

    public void setContext(Context context) {
        this.f1314a = context;
    }

    public void setDownloadPublicKey(boolean z) {
        DownloadManager.getInstance(this.f1314a).setDownloadPublicKey(z);
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
            com.baidu.clientupdate.c.a.a(this.f1314a).a(str);
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
        com.baidu.clientupdate.c.a.a(this.f1314a).a(z);
    }

    public void setUseRSA(boolean z) {
        DownloadManager.getInstance(this.f1314a).setUseRSA(z);
    }

    public void setVersionCode(String str) {
        this.n.e(str);
    }

    public void setVersionName(String str) {
        this.n.d(str);
    }

    public void startDownload(ClientUpdateInfo clientUpdateInfo, String str) {
        try {
            com.baidu.clientupdate.d.a.a(this.f1314a).b(clientUpdateInfo, str);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public void startDownload(ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        try {
            com.baidu.clientupdate.d.a.a(this.f1314a).a(clientUpdateInfo, str, z);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public void startPatchDownload(ClientUpdateInfo clientUpdateInfo, String str) {
        try {
            com.baidu.clientupdate.d.a.a(this.f1314a).a(clientUpdateInfo, str);
        } catch (Exception e2) {
            LogUtil.logE("ClientUpdater", e2.getMessage());
        }
    }

    public void throwError(JSONObject jSONObject) {
        try {
            if (this.d) {
                this.f.onError(jSONObject);
            } else if (this.g != null) {
                this.g.onError(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
