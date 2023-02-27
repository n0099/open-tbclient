package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.dp4;
import com.baidu.tieba.gm3;
import com.baidu.tieba.l93;
import com.baidu.tieba.lv3;
import com.baidu.tieba.nf2;
import com.baidu.tieba.nl3;
import com.baidu.tieba.nm4;
import com.baidu.tieba.ok1;
import com.baidu.tieba.pc2;
import com.baidu.tieba.sk1;
import com.baidu.tieba.su3;
import com.baidu.tieba.tk4;
import com.baidu.tieba.tl3;
import com.baidu.tieba.ts2;
import com.baidu.tieba.us2;
import com.baidu.tieba.wg4;
import com.baidu.tieba.wp1;
import com.baidu.tieba.yh2;
import com.baidu.webkit.sdk.WebViewFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
@Keep
/* loaded from: classes3.dex */
public class SwanAppInitHelper {
    public static final boolean DEBUG = false;
    public static final String TAG = "SwanAppInitHelper";
    public static boolean sIsDelayInit;
    public static boolean sOnlyInitForLollipopAndAbove;

    /* loaded from: classes3.dex */
    public static class b implements nf2.e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                yh2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.nf2.e
        public void a() {
            l93.M().post(new a(this));
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                wg4.m(new tk4(0), new pc2(null), us2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = nm4.c(0);
        if (!c) {
            return;
        }
        gm3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !tl3.f()) {
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
        nf2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        dp4 b2 = dp4.b();
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
        sk1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (ok1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            lv3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (wp1.a) {
                nl3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = ts2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new nf2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, nf2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            nf2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (nf2.e eVar : eVarArr) {
                if (eVar != null) {
                    nf2.h(context).f(eVar);
                }
            }
        }
        nf2.h(context).k(ProcessUtils.isMainProcess());
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
            su3.a().a(application);
            su3.b().a(application, z, z2);
        }
    }
}
