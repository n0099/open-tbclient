package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.am4;
import com.baidu.tieba.ej3;
import com.baidu.tieba.j63;
import com.baidu.tieba.js3;
import com.baidu.tieba.lc2;
import com.baidu.tieba.li3;
import com.baidu.tieba.lj4;
import com.baidu.tieba.n92;
import com.baidu.tieba.qr3;
import com.baidu.tieba.rh4;
import com.baidu.tieba.ri3;
import com.baidu.tieba.rp2;
import com.baidu.tieba.sp2;
import com.baidu.tieba.ud4;
import com.baidu.tieba.uf1;
import com.baidu.tieba.vm1;
import com.baidu.tieba.we2;
import com.baidu.tieba.yf1;
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
    public static class b implements lc2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                we2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.lc2.e
        public void a() {
            j63.M().post(new a(this));
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
                ud4.m(new rh4(0), new n92(null), sp2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = lj4.c(0);
        if (!c) {
            return;
        }
        ej3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !ri3.f()) {
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
        lc2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        am4 b2 = am4.b();
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
        yf1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (uf1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            js3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (vm1.a) {
                li3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = rp2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new lc2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, lc2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            lc2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (lc2.e eVar : eVarArr) {
                if (eVar != null) {
                    lc2.h(context).f(eVar);
                }
            }
        }
        lc2.h(context).k(ProcessUtils.isMainProcess());
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
            qr3.a().a(application);
            qr3.b().a(application, z, z2);
        }
    }
}
