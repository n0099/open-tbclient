package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import com.baidu.pyramid.runtime.multiprocess.e;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.i;
import com.baidu.swan.pms.c.d.h;
import com.baidu.swan.ubc.r;
import com.baidu.webkit.sdk.WebViewFactory;
import com.facebook.drawee.a.a.c;
@Keep
/* loaded from: classes4.dex */
public class SwanAppInitHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "SwanAppInitHelper";
    private static boolean sOnlyInitForLollipopAndAbove = false;
    private static boolean sIsDelayInit = false;

    public static void initContext(Application application) {
        initRuntimeContext(application);
    }

    public static void initModules(Application application) {
        initModules(application, sIsDelayInit);
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

    private static void initRuntimeContext(Application application) {
        AppRuntimeInit.onApplicationattachBaseContext(application);
        e.onApplicationattachBaseContext(application);
    }

    private static void initStatisticsModule(Application application) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Qn()) {
            r.aNJ();
            initConfig();
        }
    }

    private static void initSwanAppModule(Application application) {
        if (!c.dDq()) {
            c.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            a.dl(application).azd();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (b.DEBUG) {
                com.baidu.swan.apps.ap.a.an(0, 1);
            }
        }
    }

    private static void asyncUpdateSwanAppCore() {
        final boolean jP = com.baidu.swan.pms.e.a.jP(0);
        if (jP) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.facade.init.SwanAppInitHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (jP) {
                        com.baidu.swan.pms.c.a(new h(0), new i(null), new com.baidu.swan.games.k.b.a(null));
                    }
                }
            }, "asyncUpdateSwanAppCore by PMS");
        }
    }

    private static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    private static void delayInit(boolean z) {
        sIsDelayInit = z;
    }

    public static boolean entranceOK() {
        return !sOnlyInitForLollipopAndAbove || com.baidu.swan.apps.aq.c.hasLollipop();
    }

    public static boolean isDelayInit() {
        return sIsDelayInit;
    }

    private static void initWebView(Context context) {
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), com.baidu.swan.apps.t.a.ahV().UC(), false);
        if (com.baidu.swan.apps.t.a.ahV().UD()) {
            doWebViewInit(context);
        }
    }

    private static void doWebViewInit(Context context) {
        com.baidu.swan.apps.core.k.b.bM(context).dT(ProcessUtils.isMainProcess());
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.env.e.aeI().s(null);
        }
    }

    private static boolean isProcessNeedInit() {
        return ProcessUtils.isMainProcess() || ProcessUtils.isSwanProcess();
    }

    public static void onTerminate() {
        com.baidu.swan.apps.core.k.b.bM(AppRuntime.getAppContext()).onTerminate();
    }

    public static void initConfig() {
        uploadLastData();
    }

    private static void uploadLastData() {
        com.baidu.swan.ubc.p aNC = com.baidu.swan.ubc.p.aNC();
        aNC.upload();
        aNC.aND();
    }
}
