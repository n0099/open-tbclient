package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.aj3;
import com.baidu.tieba.f63;
import com.baidu.tieba.fs3;
import com.baidu.tieba.hc2;
import com.baidu.tieba.hi3;
import com.baidu.tieba.hj4;
import com.baidu.tieba.j92;
import com.baidu.tieba.mr3;
import com.baidu.tieba.nh4;
import com.baidu.tieba.ni3;
import com.baidu.tieba.np2;
import com.baidu.tieba.op2;
import com.baidu.tieba.qd4;
import com.baidu.tieba.qf1;
import com.baidu.tieba.rm1;
import com.baidu.tieba.se2;
import com.baidu.tieba.uf1;
import com.baidu.tieba.wl4;
import com.baidu.webkit.sdk.WebViewFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
@Keep
/* loaded from: classes4.dex */
public class SwanAppInitHelper {
    public static final boolean DEBUG = false;
    public static final String TAG = "SwanAppInitHelper";
    public static boolean sIsDelayInit;
    public static boolean sOnlyInitForLollipopAndAbove;

    /* loaded from: classes4.dex */
    public static class b implements hc2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                se2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.hc2.e
        public void a() {
            f63.M().post(new a(this));
        }
    }

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                qd4.m(new nh4(0), new j92(null), op2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = hj4.c(0);
        if (!c) {
            return;
        }
        aj3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !ni3.f()) {
            return false;
        }
        return true;
    }

    public static void initConfig() {
        uploadLastData();
    }

    public static boolean isDelayInit() {
        return sIsDelayInit;
    }

    public static boolean isProcessNeedInit() {
        if (!ProcessUtils.isMainProcess() && !ProcessUtils.isSwanProcess()) {
            return false;
        }
        return true;
    }

    public static void onTerminate() {
        hc2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        wl4 b2 = wl4.b();
        b2.h();
        b2.i();
    }

    public static void delayInit(boolean z) {
        sIsDelayInit = z;
    }

    public static void initContext(Application application) {
        initRuntimeContext(application);
    }

    public static void initModules(Application application) {
        initModules(application, sIsDelayInit);
    }

    public static void initRuntimeContext(Application application) {
        AppRuntimeInit.onApplicationattachBaseContext(application);
        uf1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (qf1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            fs3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (rm1.a) {
                hi3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = np2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new hc2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, hc2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            hc2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (hc2.e eVar : eVarArr) {
                if (eVar != null) {
                    hc2.h(context).f(eVar);
                }
            }
        }
        hc2.h(context).k(ProcessUtils.isMainProcess());
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
            mr3.a().a(application);
            mr3.b().a(application, z, z2);
        }
    }
}
