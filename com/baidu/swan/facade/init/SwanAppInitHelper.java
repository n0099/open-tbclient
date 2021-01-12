package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.pyramid.runtime.multiprocess.e;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.k.b;
import com.baidu.swan.apps.core.pms.i;
import com.baidu.swan.pms.c.d.h;
import com.baidu.swan.ubc.r;
import com.baidu.webkit.sdk.WebViewFactory;
import com.facebook.drawee.a.a.c;
@Keep
/* loaded from: classes6.dex */
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
        if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
            r.beY();
            initConfig();
        }
    }

    private static void initSwanAppModule(Application application) {
        if (!c.eqY()) {
            c.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            a.eu(application).aPU();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (b.DEBUG) {
                com.baidu.swan.apps.an.a.ar(0, 1);
            }
        }
    }

    private static void asyncUpdateSwanAppCore() {
        final boolean lV = com.baidu.swan.pms.g.a.lV(0);
        if (lV) {
            p.a(new Runnable() { // from class: com.baidu.swan.facade.init.SwanAppInitHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (lV) {
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
        return !sOnlyInitForLollipopAndAbove || com.baidu.swan.apps.ao.c.hasLollipop();
    }

    public static boolean isDelayInit() {
        return sIsDelayInit;
    }

    private static void initWebView(Context context) {
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), com.baidu.swan.apps.t.a.axl().aik(), false);
        if (com.baidu.swan.apps.t.a.axl().ail()) {
            doWebViewInit(context);
        }
    }

    private static void doWebViewInit(Context context) {
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.core.k.b.cL(context).a(new b.a() { // from class: com.baidu.swan.facade.init.SwanAppInitHelper.2
                @Override // com.baidu.swan.apps.core.k.b.a
                public void agb() {
                    com.baidu.swan.apps.env.e.ath().q(null);
                }
            });
        }
        com.baidu.swan.apps.core.k.b.cL(context).fr(ProcessUtils.isMainProcess());
    }

    private static boolean isProcessNeedInit() {
        return ProcessUtils.isMainProcess() || ProcessUtils.isSwanProcess();
    }

    public static void onTerminate() {
        com.baidu.swan.apps.core.k.b.cL(AppRuntime.getAppContext()).onTerminate();
    }

    public static void initConfig() {
        uploadLastData();
    }

    private static void uploadLastData() {
        com.baidu.swan.ubc.p beR = com.baidu.swan.ubc.p.beR();
        beR.upload();
        beR.beS();
    }
}
