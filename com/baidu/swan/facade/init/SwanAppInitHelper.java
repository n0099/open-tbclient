package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.bx3;
import com.baidu.tieba.cn4;
import com.baidu.tieba.co3;
import com.baidu.tieba.cv2;
import com.baidu.tieba.dv2;
import com.baidu.tieba.el1;
import com.baidu.tieba.fj4;
import com.baidu.tieba.fs1;
import com.baidu.tieba.hk2;
import com.baidu.tieba.il1;
import com.baidu.tieba.mr4;
import com.baidu.tieba.po3;
import com.baidu.tieba.ub3;
import com.baidu.tieba.ux3;
import com.baidu.tieba.wh2;
import com.baidu.tieba.wn3;
import com.baidu.tieba.wo4;
import com.baidu.tieba.ye2;
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
    public static class b implements wh2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                hk2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.wh2.e
        public void a() {
            ub3.M().post(new a(this));
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
                fj4.m(new cn4(0), new ye2(null), dv2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = wo4.c(0);
        if (!c) {
            return;
        }
        po3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !co3.f()) {
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
        wh2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        mr4 b2 = mr4.b();
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
        il1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (el1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            ux3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (fs1.a) {
                wn3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = cv2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new wh2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, wh2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            wh2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (wh2.e eVar : eVarArr) {
                if (eVar != null) {
                    wh2.h(context).f(eVar);
                }
            }
        }
        wh2.h(context).k(ProcessUtils.isMainProcess());
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
            bx3.a().a(application);
            bx3.b().a(application, z, z2);
        }
    }
}
