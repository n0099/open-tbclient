package com.baidu.mobads.g;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.jar.JarFile;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected static Thread.UncaughtExceptionHandler f3371a;

    /* renamed from: b  reason: collision with root package name */
    protected static volatile com.baidu.mobads.g.a f3372b = null;
    protected static volatile com.baidu.mobads.g.a c = null;
    protected static volatile Class d = null;
    protected static String e = null;
    protected static final Handler f = new h(Looper.getMainLooper());
    private static String i;
    private com.baidu.mobads.openad.d.a j;
    private e k;
    private final Context l;
    private c o;
    private IXAdLogger m = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private boolean n = false;
    protected Handler g = f;
    @SuppressLint({"HandlerLeak"})
    protected final Handler h = new i(this, Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            File[] listFiles = this.l.getFilesDir().listFiles();
            int i2 = 0;
            while (listFiles != null) {
                if (i2 < listFiles.length) {
                    if (listFiles[i2].getAbsolutePath().contains("__xadsdk__remote__final__") && listFiles[i2].getAbsolutePath().endsWith("dex")) {
                        listFiles[i2].delete();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.m.a().e(e2);
        }
    }

    public final String a() {
        return "8.8146";
    }

    public g(Context context) {
        if (i == null) {
            i = XAdSDKFoundationFacade.getInstance().getURIUitls().replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/pa/") + com.baidu.mobads.a.b.b() + "/__pasys_remote_banner.php";
        }
        this.l = context;
        c(context);
        if (f3371a == null) {
            f3371a = q.a(context);
            q.a(context).a(new j(this));
        }
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof q)) {
            Thread.setDefaultUncaughtExceptionHandler(f3371a);
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(e)) {
            e = context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences l() {
        return this.l.getSharedPreferences("com.baidu.mobads.loader", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        new File(f()).delete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    public void a(String str) {
        if (f3372b != null) {
            SharedPreferences.Editor edit = l().edit();
            edit.putFloat("__badApkVersion__8.8146", (float) f3372b.f3362a);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    private boolean m() {
        String string = l().getString("previousProxyVersion", null);
        return string == null || !string.equals(a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Message obtainMessage = this.g.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.g.sendMessage(obtainMessage);
    }

    protected static String c() {
        return TextUtils.isEmpty(e) ? "" : e + "__xadsdk__remote__final__builtin__.jar";
    }

    protected static String d() {
        return TextUtils.isEmpty(e) ? "" : e + "__xadsdk__remote__final__builtinversion__.jar";
    }

    protected void e() {
        d(this.l);
        String c2 = c();
        com.baidu.mobads.g.b bVar = new com.baidu.mobads.g.b(c2, this.l);
        if (com.baidu.mobads.utils.l.a(bVar)) {
            if (c(bVar)) {
                b(true);
                return;
            }
            return;
        }
        throw new b("loadBuiltInApk failed: " + c2);
    }

    private static synchronized void d(Context context) {
        synchronized (g.class) {
            try {
                String c2 = c();
                if (Double.valueOf("8.8146").doubleValue() > a(context, c2)) {
                    com.baidu.mobads.g.b bVar = new com.baidu.mobads.g.b(c2, context);
                    if (bVar.exists()) {
                        bVar.delete();
                    }
                    XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileFromAssetsTo(context, "bdxadsdk.jar", c2);
                }
            } catch (Exception e2) {
                throw new b("loadBuiltInApk failed: " + e2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.mobads.g.b bVar) {
        Class<?> b2 = bVar.b();
        synchronized (this) {
            c = new com.baidu.mobads.g.a(b2, this.l, com.baidu.mobads.a.b.a(), com.baidu.mobads.a.b.f3338a);
        }
    }

    private void b(com.baidu.mobads.g.b bVar) {
        Log.i("XAdApkLoader", "len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
        if (f3372b == null) {
            String a2 = a(this.l);
            com.baidu.mobads.g.b bVar2 = new com.baidu.mobads.g.b(a2, this.l);
            if (bVar2.exists()) {
                bVar2.delete();
            }
            try {
                XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileInputStream(new FileInputStream(bVar), a2);
            } catch (Exception e2) {
                this.m.e(e2);
            }
            f3372b = new com.baidu.mobads.g.a(bVar2.b(), this.l, com.baidu.mobads.a.b.a(), com.baidu.mobads.a.b.f3338a);
            try {
                this.m.d("XAdApkLoader", "preloaded apk.version=" + f3372b.a().getRemoteVersion());
                return;
            } catch (a e3) {
                this.m.w("XAdApkLoader", "preload local apk " + bVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + f3372b.f3362a);
                a(e3.getMessage());
                throw e3;
            }
        }
        this.m.w("XAdApkLoader", "mApkBuilder already initialized, version: " + f3372b.f3362a);
    }

    private boolean c(com.baidu.mobads.g.b bVar) {
        synchronized (this) {
            b(bVar);
            this.m.d("XAdApkLoader", "loaded: " + bVar.getPath());
        }
        return true;
    }

    private boolean n() {
        try {
            if (!com.baidu.mobads.utils.l.b(c())) {
                if (!com.baidu.mobads.utils.l.b(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            this.m.d(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!z && !n()) {
            this.n = true;
        } else {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        }
        new Handler(Looper.getMainLooper()).postDelayed(new k(this, z), this.n ? 0L : 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        try {
            if (this.j != null) {
                this.j.removeAllListeners();
                this.j.a();
            }
            this.j = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        q.a(this.l).b();
        if (this.o != null) {
            this.o.a(z);
            this.o = null;
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(e)) {
            e = context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/";
        }
        return TextUtils.isEmpty(e) ? "" : e + "__xadsdk__remote__final__running__.jar";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String f() {
        return TextUtils.isEmpty(e) ? "" : e + "__xadsdk__remote__final__downloaded__.jar";
    }

    protected void g() {
        if (p()) {
            b(true);
            return;
        }
        this.m.d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.m.e("XAdApkLoader", "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        com.baidu.mobads.g.b bVar = new com.baidu.mobads.g.b(f(), this.l);
        if (com.baidu.mobads.utils.l.a(bVar)) {
            try {
                if (m()) {
                    throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                }
                synchronized (this) {
                    Log.i("XAdApkLoader", "loadDownloadedOrBuiltInApk len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
                    b(bVar);
                    double d2 = l().getFloat("__badApkVersion__8.8146", -1.0f);
                    this.m.d("XAdApkLoader", "downloadedApkFile.getApkVersion(): " + bVar.c() + ", badApkVersion: " + d2);
                    if (bVar.c() == d2) {
                        throw new a("downloaded file marked bad, drop it and use built-in");
                    }
                    this.m.d("XAdApkLoader", "loaded: " + bVar.getPath());
                }
                return true;
            } catch (a e2) {
                this.m.e("XAdApkLoader", "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
                if (bVar != null && bVar.exists()) {
                    bVar.delete();
                }
                i();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (eVar.a().booleanValue()) {
            com.baidu.mobads.g.c a2 = com.baidu.mobads.g.c.a(this.l, eVar, e, this.h);
            if (!a2.isAlive()) {
                this.m.d("XAdApkLoader", "XApkDownloadThread starting ...");
                a2.start();
                return;
            }
            this.m.d("XAdApkLoader", "XApkDownloadThread already started");
            a2.a(eVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        this.o = cVar;
        this.g = handler;
        if (f3372b == null) {
            g();
        } else {
            b(true);
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        new Thread(new n(this, cVar, handler)).start();
    }

    public void a(c cVar) {
        a(cVar, f);
    }

    public IXAdContainerFactory h() {
        return a(f3372b);
    }

    private IXAdContainerFactory a(com.baidu.mobads.g.a aVar) {
        if (aVar != null) {
            try {
                return aVar.a();
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    protected void i() {
        if (f3372b != null) {
            f3372b.b();
            f3372b = null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a extends Exception {
        public a(String str) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static final class b extends Exception {
        public b(String str) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
        }
    }

    public static double b(Context context) {
        try {
            c(context);
            double a2 = a(context, f());
            String d2 = d();
            if (Double.valueOf("8.8146").doubleValue() > a(context, d2)) {
                com.baidu.mobads.g.b bVar = new com.baidu.mobads.g.b(d2, context);
                if (bVar.exists()) {
                    bVar.delete();
                }
                XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileFromAssetsTo(context, "bdxadsdk.jar", d2);
            }
            return Math.max(a2, a(context, d()));
        } catch (Exception e2) {
            return 0.0d;
        }
    }

    public static double a(Context context, String str) {
        try {
            File file = new File(str);
            if (com.baidu.mobads.utils.l.a(file)) {
                JarFile jarFile = new JarFile(file);
                double parseDouble = Double.parseDouble(jarFile.getManifest().getMainAttributes().getValue("Implementation-Version"));
                jarFile.close();
                if (parseDouble > 0.0d) {
                    return parseDouble;
                }
            }
        } catch (Exception e2) {
        }
        return 0.0d;
    }
}
