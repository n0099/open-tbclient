package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.ao3;
import com.baidu.tieba.fb3;
import com.baidu.tieba.fx3;
import com.baidu.tieba.hh2;
import com.baidu.tieba.hn3;
import com.baidu.tieba.ho4;
import com.baidu.tieba.je2;
import com.baidu.tieba.mw3;
import com.baidu.tieba.nm4;
import com.baidu.tieba.nn3;
import com.baidu.tieba.nu2;
import com.baidu.tieba.ou2;
import com.baidu.tieba.pk1;
import com.baidu.tieba.qi4;
import com.baidu.tieba.qr1;
import com.baidu.tieba.sj2;
import com.baidu.tieba.tk1;
import com.baidu.tieba.xq4;
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
    public static class b implements hh2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                sj2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.hh2.e
        public void a() {
            fb3.M().post(new a(this));
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
                qi4.m(new nm4(0), new je2(null), ou2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = ho4.c(0);
        if (!c) {
            return;
        }
        ao3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !nn3.f()) {
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
        hh2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        xq4 b2 = xq4.b();
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
        tk1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (pk1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            fx3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (qr1.a) {
                hn3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = nu2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new hh2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, hh2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            hh2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (hh2.e eVar : eVarArr) {
                if (eVar != null) {
                    hh2.h(context).f(eVar);
                }
            }
        }
        hh2.h(context).k(ProcessUtils.isMainProcess());
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
            mw3.a().a(application);
            mw3.b().a(application, z, z2);
        }
    }
}
