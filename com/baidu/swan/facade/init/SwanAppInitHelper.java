package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.bj3;
import com.baidu.tieba.g63;
import com.baidu.tieba.gs3;
import com.baidu.tieba.ic2;
import com.baidu.tieba.ii3;
import com.baidu.tieba.ij4;
import com.baidu.tieba.k92;
import com.baidu.tieba.nr3;
import com.baidu.tieba.oh4;
import com.baidu.tieba.oi3;
import com.baidu.tieba.op2;
import com.baidu.tieba.pp2;
import com.baidu.tieba.rd4;
import com.baidu.tieba.rf1;
import com.baidu.tieba.sm1;
import com.baidu.tieba.te2;
import com.baidu.tieba.vf1;
import com.baidu.tieba.xl4;
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
    public static class b implements ic2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                te2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.ic2.e
        public void a() {
            g63.M().post(new a(this));
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
                rd4.m(new oh4(0), new k92(null), pp2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = ij4.c(0);
        if (!c) {
            return;
        }
        bj3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !oi3.f()) {
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
        ic2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        xl4 b2 = xl4.b();
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
        vf1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (rf1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            gs3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (sm1.a) {
                ii3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = op2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new ic2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, ic2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            ic2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (ic2.e eVar : eVarArr) {
                if (eVar != null) {
                    ic2.h(context).f(eVar);
                }
            }
        }
        ic2.h(context).k(ProcessUtils.isMainProcess());
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
            nr3.a().a(application);
            nr3.b().a(application, z, z2);
        }
    }
}
