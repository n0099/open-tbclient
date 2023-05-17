package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.am3;
import com.baidu.tieba.ck1;
import com.baidu.tieba.f93;
import com.baidu.tieba.fv3;
import com.baidu.tieba.hf2;
import com.baidu.tieba.hl3;
import com.baidu.tieba.hm4;
import com.baidu.tieba.jc2;
import com.baidu.tieba.mu3;
import com.baidu.tieba.nk4;
import com.baidu.tieba.nl3;
import com.baidu.tieba.ns2;
import com.baidu.tieba.os2;
import com.baidu.tieba.qg4;
import com.baidu.tieba.qp1;
import com.baidu.tieba.sh2;
import com.baidu.tieba.xo4;
import com.baidu.tieba.yj1;
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
    public static class b implements hf2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                sh2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.hf2.e
        public void a() {
            f93.M().post(new a(this));
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
                qg4.m(new nk4(0), new jc2(null), os2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = hm4.c(0);
        if (!c) {
            return;
        }
        am3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !nl3.f()) {
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
        hf2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        xo4 b2 = xo4.b();
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
        ck1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (yj1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            fv3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (qp1.a) {
                hl3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = ns2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new hf2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, hf2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            hf2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (hf2.e eVar : eVarArr) {
                if (eVar != null) {
                    hf2.h(context).f(eVar);
                }
            }
        }
        hf2.h(context).k(ProcessUtils.isMainProcess());
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
            mu3.a().a(application);
            mu3.b().a(application, z, z2);
        }
    }
}
