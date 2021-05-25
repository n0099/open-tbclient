package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.webkit.sdk.WebViewFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import d.a.e0.b.a.e;
import d.a.l0.a.a2.d;
import d.a.l0.a.h0.m.i;
import d.a.l0.a.h0.s.b;
import d.a.l0.a.k;
import d.a.l0.a.n0.f;
import d.a.l0.a.v2.q;
import d.a.l0.n.i.m.h;
import d.a.l0.r.p;
@Keep
/* loaded from: classes3.dex */
public class SwanAppInitHelper {
    public static final boolean DEBUG = false;
    public static final String TAG = "SwanAppInitHelper";
    public static boolean sIsDelayInit = false;
    public static boolean sOnlyInitForLollipopAndAbove = false;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11466e;

        public a(boolean z) {
            this.f11466e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11466e) {
                d.a.l0.n.b.k(new h(0), new i(null), d.a.l0.a.c1.b.i().p(null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements b.c {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.c().e(null);
            }
        }

        @Override // d.a.l0.a.h0.s.b.c
        public void a() {
            d.i().post(new a(this));
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c2 = d.a.l0.n.n.a.c(0);
        if (c2) {
            q.j(new a(c2), "asyncUpdateSwanAppCore by PMS");
        }
    }

    public static void delayInit(boolean z) {
        sIsDelayInit = z;
    }

    public static void doWebViewInit(Context context, b.c... cVarArr) {
        if (ProcessUtils.isMainProcess()) {
            d.a.l0.a.h0.s.b.g(context).e(new b());
        }
        if (cVarArr != null && cVarArr.length > 0) {
            for (b.c cVar : cVarArr) {
                if (cVar != null) {
                    d.a.l0.a.h0.s.b.g(context).e(cVar);
                }
            }
        }
        d.a.l0.a.h0.s.b.g(context).j(ProcessUtils.isMainProcess());
    }

    public static boolean entranceOK() {
        return !sOnlyInitForLollipopAndAbove || d.a.l0.a.v2.d.f();
    }

    public static void initConfig() {
        uploadLastData();
    }

    public static void initContext(Application application) {
        initRuntimeContext(application);
    }

    public static void initModules(Application application) {
        initModules(application, sIsDelayInit);
    }

    public static void initRuntimeContext(Application application) {
        AppRuntimeInit.onApplicationattachBaseContext(application);
        e.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (d.a.e0.b.a.a.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            d.a.l0.e.k.b.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (k.f43199a) {
                d.a.l0.a.t2.a.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d2 = d.a.l0.a.c1.a.n0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d2, false);
        doWebViewInit(context, new b.c[0]);
    }

    public static boolean isDelayInit() {
        return sIsDelayInit;
    }

    public static boolean isProcessNeedInit() {
        return ProcessUtils.isMainProcess() || ProcessUtils.isSwanProcess();
    }

    public static void onTerminate() {
        d.a.l0.a.h0.s.b.g(AppRuntime.getAppContext()).m();
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void uploadLastData() {
        p b2 = p.b();
        b2.h();
        b2.i();
    }

    public static void initModules(Application application, boolean z) {
        initModules(application, z, sOnlyInitForLollipopAndAbove);
    }

    public static void initModules(Application application, boolean z, boolean z2) {
        onlyInitForLollipopAndAbove(z2);
        delayInit(z);
        if (entranceOK() && !isDelayInit() && isProcessNeedInit()) {
            initStatisticsModule(application);
            initSwanAppModule(application);
            d.a.l0.e.f.a().a(application);
            d.a.l0.e.f.b().a(application, z, z2);
        }
    }
}
