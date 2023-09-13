package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.bo3;
import com.baidu.tieba.gb3;
import com.baidu.tieba.gx3;
import com.baidu.tieba.ih2;
import com.baidu.tieba.in3;
import com.baidu.tieba.io4;
import com.baidu.tieba.ke2;
import com.baidu.tieba.nw3;
import com.baidu.tieba.om4;
import com.baidu.tieba.on3;
import com.baidu.tieba.ou2;
import com.baidu.tieba.pu2;
import com.baidu.tieba.qk1;
import com.baidu.tieba.ri4;
import com.baidu.tieba.rr1;
import com.baidu.tieba.tj2;
import com.baidu.tieba.uk1;
import com.baidu.tieba.yq4;
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
    public static class b implements ih2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                tj2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.ih2.e
        public void a() {
            gb3.M().post(new a(this));
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
                ri4.m(new om4(0), new ke2(null), pu2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = io4.c(0);
        if (!c) {
            return;
        }
        bo3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !on3.f()) {
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
        ih2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        yq4 b2 = yq4.b();
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
        uk1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (qk1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            gx3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (rr1.a) {
                in3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = ou2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new ih2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, ih2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            ih2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (ih2.e eVar : eVarArr) {
                if (eVar != null) {
                    ih2.h(context).f(eVar);
                }
            }
        }
        ih2.h(context).k(ProcessUtils.isMainProcess());
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
            nw3.a().a(application);
            nw3.b().a(application, z, z2);
        }
    }
}
