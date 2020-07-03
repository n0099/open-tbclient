package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import com.baidu.pyramid.runtime.multiprocess.e;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.i;
import com.baidu.swan.pms.c.d.g;
import com.baidu.swan.ubc.n;
import com.baidu.swan.ubc.r;
import com.baidu.webkit.sdk.WebViewFactory;
import com.facebook.drawee.a.a.c;
@Keep
/* loaded from: classes11.dex */
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
        if (com.baidu.pyramid.runtime.multiprocess.a.PY()) {
            r.aJS();
            n.aJJ().initConfig();
        }
    }

    private static void initSwanAppModule(Application application) {
        if (!c.dzZ()) {
            c.initialize(application);
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            a.dg(application).awp();
            asyncUpdateSwanAppCore();
            if (b.DEBUG) {
                com.baidu.swan.apps.ap.a.an(0, 1);
            }
        }
    }

    private static void asyncUpdateSwanAppCore() {
        final boolean jw = com.baidu.swan.pms.e.a.jw(0);
        if (jw) {
            com.baidu.swan.apps.aq.n.postOnIO(new Runnable() { // from class: com.baidu.swan.facade.init.SwanAppInitHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (jw) {
                        com.baidu.swan.pms.c.a(new g(0), new i(null), new com.baidu.swan.games.k.b.a(null));
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
        return !sOnlyInitForLollipopAndAbove || com.baidu.swan.apps.aq.b.hasLollipop();
    }

    public static boolean isDelayInit() {
        return sIsDelayInit;
    }

    private static void initWebView(Context context) {
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), com.baidu.swan.apps.u.a.agI().Ub(), false);
        if (com.baidu.swan.apps.u.a.agI().Uc()) {
            doWebViewInit(context);
        }
    }

    private static void doWebViewInit(Context context) {
        com.baidu.swan.apps.core.k.b.bJ(context).dP(ProcessUtils.isMainProcess());
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.env.e.adB().s(null);
        }
    }

    private static boolean isProcessNeedInit() {
        return ProcessUtils.isMainProcess() || ProcessUtils.isSwanProcess();
    }

    public static void onTerminate() {
        com.baidu.swan.apps.core.k.b.bJ(AppRuntime.getAppContext()).onTerminate();
    }
}
