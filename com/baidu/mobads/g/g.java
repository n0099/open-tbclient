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
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f8279a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.baidu.mobads.g.a f8280b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.baidu.mobads.g.a f8281c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile Class f8282d;

    /* renamed from: e  reason: collision with root package name */
    public static String f8283e;

    /* renamed from: f  reason: collision with root package name */
    public static final Handler f8284f = new h(Looper.getMainLooper());
    public static String i;
    public com.baidu.mobads.openad.b.a j;
    public e k;
    public final Context l;
    public IXAdLogger m = XAdSDKFoundationFacade.getInstance().getAdLogger();
    public boolean n = false;

    /* renamed from: g  reason: collision with root package name */
    public Handler f8285g = f8284f;
    public CopyOnWriteArrayList<c> o = new CopyOnWriteArrayList<>();
    @SuppressLint({"HandlerLeak"})

    /* renamed from: h  reason: collision with root package name */
    public final Handler f8286h = new i(this, Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public static final class a extends Exception {
        public a(String str) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends Exception {
        public b(String str) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(boolean z);
    }

    public g(Context context) {
        if (i == null) {
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            i = uRIUitls.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/pa/") + XAdSDKProxyVersion.getMajorVersionNumber() + "/__pasys_remote_banner.php";
        }
        this.l = context;
        c(context);
        if (f8279a == null) {
            f8279a = q.a(context);
            q.a(context).a(new j(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof q) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(f8279a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            File[] listFiles = this.l.getFilesDir().listFiles();
            int i2 = 0;
            while (listFiles != null) {
                if (i2 >= listFiles.length) {
                    return;
                }
                if (listFiles[i2].getAbsolutePath().contains("__xadsdk__remote__final__") && listFiles[i2].getAbsolutePath().endsWith("dex")) {
                    listFiles[i2].delete();
                }
                i2++;
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences k() {
        return this.l.getSharedPreferences("com.baidu.mobads.loader", 0);
    }

    private boolean l() {
        String string = k().getString("previousProxyVersion", null);
        return string == null || !string.equals(a());
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
    public synchronized void n() {
        try {
            if (this.j != null) {
                this.j.removeAllListeners();
                this.j.a();
            }
            this.j = null;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        com.baidu.mobads.g.b bVar = new com.baidu.mobads.g.b(f(), this.l);
        if (com.baidu.mobads.utils.p.a(bVar)) {
            try {
                if (!l()) {
                    synchronized (this) {
                        IXAdLogger iXAdLogger = this.m;
                        iXAdLogger.d("XAdApkLoader", "loadDownloadedOrBuiltInApk len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
                        b(bVar);
                        double d2 = (double) k().getFloat("__badApkVersion__8.8448", -1.0f);
                        IXAdLogger iXAdLogger2 = this.m;
                        iXAdLogger2.d("XAdApkLoader", "downloadedApkFile.getApkVersion(): " + bVar.c() + ", badApkVersion: " + d2);
                        if (bVar.c() != d2) {
                            IXAdLogger iXAdLogger3 = this.m;
                            iXAdLogger3.d("XAdApkLoader", "loaded: " + bVar.getPath());
                        } else {
                            throw new a("downloaded file marked bad, drop it and use built-in");
                        }
                    }
                    return true;
                }
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            } catch (a e2) {
                IXAdLogger iXAdLogger4 = this.m;
                iXAdLogger4.d("XAdApkLoader", "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
                if (bVar.exists()) {
                    bVar.delete();
                }
                i();
                return false;
            }
        }
        return false;
    }

    public final String a() {
        return XAdSDKProxyVersion.RELEASE_TAG;
    }

    public void i() {
        if (f8280b != null) {
            f8280b.b();
            f8280b = null;
        }
    }

    public static String f() {
        if (TextUtils.isEmpty(f8283e)) {
            return "";
        }
        return f8283e + "__xadsdk__remote__final__downloaded__.jar";
    }

    public void e() {
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

    public void g() {
        if (o()) {
            b(true);
            return;
        }
        this.m.d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            IXAdLogger iXAdLogger = this.m;
            iXAdLogger.d("XAdApkLoader", "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    public IXAdContainerFactory h() {
        return a(f8280b);
    }

    public static void c(Context context) {
        if (TextUtils.isEmpty(f8283e)) {
            File dir = context.getDir("baidu_ad_sdk", 0);
            f8283e = dir.getAbsolutePath() + "/";
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f8283e)) {
            return "";
        }
        return f8283e + "__xadsdk__remote__final__builtinversion__.jar";
    }

    public void b() {
        new File(f()).delete();
    }

    public static synchronized void d(Context context) {
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

    private void b(com.baidu.mobads.g.b bVar) {
        IXAdLogger iXAdLogger = this.m;
        iXAdLogger.d("XAdApkLoader", "len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
        if (f8280b == null) {
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
            f8280b = new com.baidu.mobads.g.a(bVar2.b(), this.l, XAdSDKProxyVersion.getVersion(), XAdSDKProxyVersion.DEBUG);
            try {
                IXAdContainerFactory a3 = f8280b.a();
                IXAdLogger iXAdLogger2 = this.m;
                iXAdLogger2.d("XAdApkLoader", "preloaded apk.version=" + a3.getRemoteVersion());
                return;
            } catch (a e3) {
                IXAdLogger iXAdLogger3 = this.m;
                iXAdLogger3.d("XAdApkLoader", "preload local apk " + bVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + f8280b.f8250a);
                a(e3.getMessage());
                throw e3;
            }
        }
        IXAdLogger iXAdLogger4 = this.m;
        iXAdLogger4.d("XAdApkLoader", "mApkBuilder already initialized, version: " + f8280b.f8250a);
    }

    public static String c() {
        if (TextUtils.isEmpty(f8283e)) {
            return "";
        }
        return f8283e + "__xadsdk__remote__final__builtin__.jar";
    }

    @TargetApi(9)
    public void a(String str) {
        if (f8280b != null) {
            SharedPreferences.Editor edit = k().edit();
            edit.putFloat("__badApkVersion__8.8448", (float) f8280b.f8250a);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    private boolean c(com.baidu.mobads.g.b bVar) {
        synchronized (this) {
            b(bVar);
            IXAdLogger iXAdLogger = this.m;
            iXAdLogger.d("XAdApkLoader", "loaded: " + bVar.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Message obtainMessage = this.f8285g.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f8285g.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        try {
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            double d2 = z ? f8280b.f8250a : 0.0d;
            m mVar = new m(this, d2);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("v", "" + d2);
            hashMap.put(IXAdRequestInfo.OS, "android");
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.MODEL));
            hashMap.put(IXAdRequestInfo.BDR, XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.VERSION.SDK));
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(uRIUitls.addParameters(i, hashMap), "");
            bVar.f8414e = 1;
            com.baidu.mobads.openad.b.a aVar = new com.baidu.mobads.openad.b.a();
            this.j = aVar;
            aVar.addEventListener("URLLoader.Load.Complete", mVar);
            this.j.addEventListener("URLLoader.Load.Error", mVar);
            this.j.a(bVar);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.mobads.g.b bVar) {
        Class<?> b2 = bVar.b();
        synchronized (this) {
            f8281c = new com.baidu.mobads.g.a(b2, this.l, XAdSDKProxyVersion.getVersion(), XAdSDKProxyVersion.DEBUG);
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

    public static String a(Context context) {
        if (TextUtils.isEmpty(f8283e)) {
            File dir = context.getDir("baidu_ad_sdk", 0);
            f8283e = dir.getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(f8283e)) {
            return "";
        }
        return f8283e + "__xadsdk__remote__final__running__.jar";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.o;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.o.add(cVar);
        }
        this.f8285g = handler;
        if (f8280b == null) {
            g();
        } else {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (eVar.a().booleanValue()) {
            com.baidu.mobads.g.c a2 = com.baidu.mobads.g.c.a(this.l, eVar, f8283e, this.f8286h);
            if (!a2.isAlive()) {
                this.m.d("XAdApkLoader", "XApkDownloadThread starting ...");
                a2.start();
                return;
            }
            this.m.d("XAdApkLoader", "XApkDownloadThread already started");
            a2.a(eVar.c());
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
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new n(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, f8284f);
    }

    private IXAdContainerFactory a(com.baidu.mobads.g.a aVar) {
        if (aVar != null) {
            try {
                return aVar.a();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
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
        } catch (Exception unused) {
        }
        return 0.0d;
    }
}
