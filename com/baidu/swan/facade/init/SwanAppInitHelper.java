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
import d.a.h0.a.e0.p.i;
import d.a.h0.a.e0.u.b;
import d.a.h0.a.i2.p;
import d.a.h0.a.j0.e;
import d.a.h0.a.k;
import d.a.h0.l.c;
import d.a.h0.l.l.k.h;
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
        public final /* synthetic */ boolean f12289e;

        public a(boolean z) {
            this.f12289e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12289e) {
                c.i(new h(0), new i(null), new d.a.h0.g.n.b.a(null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements b.c {
        @Override // d.a.h0.a.e0.u.b.c
        public void a() {
            e.c().e(null);
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c2 = d.a.h0.l.q.a.c(0);
        if (c2) {
            p.k(new a(c2), "asyncUpdateSwanAppCore by PMS");
        }
    }

    public static void delayInit(boolean z) {
        sIsDelayInit = z;
    }

    public static void doWebViewInit(Context context) {
        if (ProcessUtils.isMainProcess()) {
            d.a.h0.a.e0.u.b.h(context).e(new b());
        }
        d.a.h0.a.e0.u.b.h(context).k(ProcessUtils.isMainProcess());
    }

    public static boolean entranceOK() {
        return !sOnlyInitForLollipopAndAbove || d.a.h0.a.i2.c.f();
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
        d.a.c0.b.a.e.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (d.a.c0.b.a.a.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            d.a.h0.d.g.a.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (k.f43101a) {
                d.a.h0.a.h2.a.b(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d.a.h0.a.w0.a.b0().c(), false);
        if (d.a.h0.a.w0.a.b0().b()) {
            doWebViewInit(context);
        }
    }

    public static boolean isDelayInit() {
        return sIsDelayInit;
    }

    public static boolean isProcessNeedInit() {
        return ProcessUtils.isMainProcess() || ProcessUtils.isSwanProcess();
    }

    public static void onTerminate() {
        d.a.h0.a.e0.u.b.h(AppRuntime.getAppContext()).n();
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void uploadLastData() {
        d.a.h0.n.p b2 = d.a.h0.n.p.b();
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
        }
    }
}
