package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import com.baidu.pyramid.runtime.multiprocess.e;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.j.b;
import com.baidu.swan.config.d;
import com.baidu.swan.ubc.m;
import com.baidu.swan.ubc.q;
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
        AppRuntimeInit.onApplicationAttachBaseContext(application);
        e.onApplicationAttachBaseContext(application);
    }

    private static void initStatisticsModule(Application application) {
        if (com.baidu.pyramid.runtime.multiprocess.a.MF()) {
            q.aEd();
            m.aDT().initConfig();
        }
    }

    private static void initSwanAppModule(Application application) {
        if (!c.dnP()) {
            c.initialize(application);
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            a.cQ(application).arA();
            asyncUpdateSwanConfig();
            com.baidu.swan.apps.ar.a.ai(0, 1);
        }
    }

    private static void asyncUpdateSwanConfig() {
        d.arh();
    }

    private static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    private static void delayInit(boolean z) {
        sIsDelayInit = z;
    }

    public static boolean entranceOK() {
        return !sOnlyInitForLollipopAndAbove || com.baidu.swan.apps.as.a.hasLollipop();
    }

    public static boolean isDelayInit() {
        return sIsDelayInit;
    }

    private static void initWebView(Context context) {
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), com.baidu.swan.apps.w.a.acz().Qr(), false);
        if (com.baidu.swan.apps.w.a.acz().Qs()) {
            doWebViewInit(context);
        }
    }

    private static void doWebViewInit(Context context) {
        b.bz(context).dv(ProcessUtils.isMainProcess());
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.env.e.Zu().p(null);
        }
    }

    private static boolean isProcessNeedInit() {
        return ProcessUtils.isMainProcess() || ProcessUtils.isSwanProcess();
    }

    public static void onTerminate() {
        b.bz(AppRuntime.getAppContext()).onTerminate();
    }
}
