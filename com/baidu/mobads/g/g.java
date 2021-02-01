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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected static Thread.UncaughtExceptionHandler f3345a;

    /* renamed from: b  reason: collision with root package name */
    protected static volatile com.baidu.mobads.g.a f3346b = null;
    protected static volatile com.baidu.mobads.g.a c = null;
    protected static volatile Class d = null;
    protected static String e = null;
    protected static final Handler f = new h(Looper.getMainLooper());
    private static String i;
    private com.baidu.mobads.openad.b.a j;
    private e k;
    private final Context l;
    private IXAdLogger m = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private boolean n = false;
    protected Handler g = f;
    private CopyOnWriteArrayList<c> o = new CopyOnWriteArrayList<>();
    @SuppressLint({"HandlerLeak"})
    protected final Handler h = new i(this, Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
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
            com.baidu.mobads.utils.q.a().e(e2);
        }
    }

    public final String a() {
        return XAdSDKProxyVersion.RELEASE_TAG;
    }

    public g(Context context) {
        if (i == null) {
            i = XAdSDKFoundationFacade.getInstance().getURIUitls().replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/pa/") + XAdSDKProxyVersion.getMajorVersionNumber() + "/__pasys_remote_banner.php";
        }
        this.l = context;
        c(context);
        if (f3345a == null) {
            f3345a = q.a(context);
            q.a(context).a(new j(this));
        }
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof q)) {
            Thread.setDefaultUncaughtExceptionHandler(f3345a);
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(e)) {
            e = context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences k() {
        return this.l.getSharedPreferences("com.baidu.mobads.loader", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        new File(f()).delete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    public void a(String str) {
        if (f3346b != null) {
            SharedPreferences.Editor edit = k().edit();
            edit.putFloat("__badApkVersion__8.8451", (float) f3346b.f3336a);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    private boolean l() {
        String string = k().getString("previousProxyVersion", null);
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
        if (com.baidu.mobads.utils.p.a(bVar)) {
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
                if (Double.valueOf(XAdSDKProxyVersion.RELEASE_TAG).doubleValue() > a(context, c2)) {
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
            c = new com.baidu.mobads.g.a(b2, this.l, XAdSDKProxyVersion.getVersion(), XAdSDKProxyVersion.DEBUG);
        }
    }

    private void b(com.baidu.mobads.g.b bVar) {
        this.m.d("XAdApkLoader", "len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
        if (f3346b == null) {
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
            f3346b = new com.baidu.mobads.g.a(bVar2.b(), this.l, XAdSDKProxyVersion.getVersion(), XAdSDKProxyVersion.DEBUG);
            try {
                this.m.d("XAdApkLoader", "preloaded apk.version=" + f3346b.a().getRemoteVersion());
                return;
            } catch (a e3) {
                this.m.d("XAdApkLoader", "preload local apk " + bVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + f3346b.f3336a);
                a(e3.getMessage());
                throw e3;
            }
        }
        this.m.d("XAdApkLoader", "mApkBuilder already initialized, version: " + f3346b.f3336a);
    }

    private boolean c(com.baidu.mobads.g.b bVar) {
        synchronized (this) {
            b(bVar);
            this.m.d("XAdApkLoader", "loaded: " + bVar.getPath());
        }
        return true;
    }

    private boolean m() {
        try {
            if (!com.baidu.mobads.utils.p.b(c())) {
                if (!com.baidu.mobads.utils.p.b(f())) {
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
        if (!z && !m()) {
            this.n = true;
        } else {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.n) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new k(this, z));
        } else {
            com.baidu.mobads.f.c.a().a(new l(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        try {
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            double d2 = z ? f3346b.f3336a : 0.0d;
            if (z) {
            }
            m mVar = new m(this, d2);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("v", "" + d2);
            hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.MODEL));
            hashMap.put(IXAdRequestInfo.BDR, XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.VERSION.SDK));
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(uRIUitls.addParameters(i, hashMap), "");
            bVar.e = 1;
            this.j = new com.baidu.mobads.openad.b.a();
            this.j.addEventListener("URLLoader.Load.Complete", mVar);
            this.j.addEventListener("URLLoader.Load.Error", mVar);
            this.j.a(bVar);
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n() {
        try {
            if (this.j != null) {
                this.j.removeAllListeners();
                this.j.a();
            }
            this.j = null;
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str) {
        q.a(this.l).b();
        if (this.o != null && this.o.size() > 0) {
            Iterator<c> it = this.o.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.a(z);
                this.o.remove(next);
            }
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
        if (o()) {
            b(true);
            return;
        }
        this.m.d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.m.d("XAdApkLoader", "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        com.baidu.mobads.g.b bVar = new com.baidu.mobads.g.b(f(), this.l);
        if (com.baidu.mobads.utils.p.a(bVar)) {
            try {
                if (l()) {
                    throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                }
                synchronized (this) {
                    this.m.d("XAdApkLoader", "loadDownloadedOrBuiltInApk len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
                    b(bVar);
                    double d2 = k().getFloat("__badApkVersion__8.8451", -1.0f);
                    this.m.d("XAdApkLoader", "downloadedApkFile.getApkVersion(): " + bVar.c() + ", badApkVersion: " + d2);
                    if (bVar.c() == d2) {
                        throw new a("downloaded file marked bad, drop it and use built-in");
                    }
                    this.m.d("XAdApkLoader", "loaded: " + bVar.getPath());
                }
                return true;
            } catch (a e2) {
                this.m.d("XAdApkLoader", "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
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
        if (this.o != null && !this.o.contains(cVar)) {
            this.o.add(cVar);
        }
        this.g = handler;
        if (f3346b == null) {
            g();
        } else {
            b(true);
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new n(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, f);
    }

    public IXAdContainerFactory h() {
        return a(f3346b);
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
        if (f3346b != null) {
            f3346b.b();
            f3346b = null;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends Exception {
        public a(String str) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
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
            if (Double.valueOf(XAdSDKProxyVersion.RELEASE_TAG).doubleValue() > a(context, d2)) {
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
            if (com.baidu.mobads.utils.p.a(file)) {
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
