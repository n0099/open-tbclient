package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.bt3;
import com.baidu.tieba.cj4;
import com.baidu.tieba.ck3;
import com.baidu.tieba.cr2;
import com.baidu.tieba.dr2;
import com.baidu.tieba.ff4;
import com.baidu.tieba.fo1;
import com.baidu.tieba.gj1;
import com.baidu.tieba.hg2;
import com.baidu.tieba.kj1;
import com.baidu.tieba.mn4;
import com.baidu.tieba.pk3;
import com.baidu.tieba.u73;
import com.baidu.tieba.ut3;
import com.baidu.tieba.wd2;
import com.baidu.tieba.wj3;
import com.baidu.tieba.wk4;
import com.baidu.tieba.ya2;
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
    public static class b implements wd2.e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                hg2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.wd2.e
        public void a() {
            u73.M().post(new a(this));
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
                ff4.m(new cj4(0), new ya2(null), dr2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = wk4.c(0);
        if (!c) {
            return;
        }
        pk3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !ck3.f()) {
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
        wd2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        mn4 b2 = mn4.b();
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
        kj1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (gj1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            ut3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (fo1.a) {
                wj3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = cr2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new wd2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, wd2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            wd2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (wd2.e eVar : eVarArr) {
                if (eVar != null) {
                    wd2.h(context).f(eVar);
                }
            }
        }
        wd2.h(context).k(ProcessUtils.isMainProcess());
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
            bt3.a().a(application);
            bt3.b().a(application, z, z2);
        }
    }
}
