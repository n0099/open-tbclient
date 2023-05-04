package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.ab2;
import com.baidu.tieba.dt3;
import com.baidu.tieba.ej4;
import com.baidu.tieba.ek3;
import com.baidu.tieba.er2;
import com.baidu.tieba.fr2;
import com.baidu.tieba.hf4;
import com.baidu.tieba.ho1;
import com.baidu.tieba.ij1;
import com.baidu.tieba.jg2;
import com.baidu.tieba.mj1;
import com.baidu.tieba.on4;
import com.baidu.tieba.rk3;
import com.baidu.tieba.w73;
import com.baidu.tieba.wt3;
import com.baidu.tieba.yd2;
import com.baidu.tieba.yj3;
import com.baidu.tieba.yk4;
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
    public static class b implements yd2.e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                jg2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.yd2.e
        public void a() {
            w73.M().post(new a(this));
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
                hf4.m(new ej4(0), new ab2(null), fr2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = yk4.c(0);
        if (!c) {
            return;
        }
        rk3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !ek3.f()) {
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
        yd2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        on4 b2 = on4.b();
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
        mj1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (ij1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            wt3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (ho1.a) {
                yj3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = er2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new yd2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, yd2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            yd2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (yd2.e eVar : eVarArr) {
                if (eVar != null) {
                    yd2.h(context).f(eVar);
                }
            }
        }
        yd2.h(context).k(ProcessUtils.isMainProcess());
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
            dt3.a().a(application);
            dt3.b().a(application, z, z2);
        }
    }
}
