package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.cb3;
import com.baidu.tieba.cx3;
import com.baidu.tieba.eh2;
import com.baidu.tieba.en3;
import com.baidu.tieba.eo4;
import com.baidu.tieba.ge2;
import com.baidu.tieba.jw3;
import com.baidu.tieba.km4;
import com.baidu.tieba.kn3;
import com.baidu.tieba.ku2;
import com.baidu.tieba.lu2;
import com.baidu.tieba.mk1;
import com.baidu.tieba.ni4;
import com.baidu.tieba.nr1;
import com.baidu.tieba.pj2;
import com.baidu.tieba.qk1;
import com.baidu.tieba.uq4;
import com.baidu.tieba.xn3;
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
    public static class b implements eh2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                pj2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.eh2.e
        public void a() {
            cb3.M().post(new a(this));
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
                ni4.m(new km4(0), new ge2(null), lu2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = eo4.c(0);
        if (!c) {
            return;
        }
        xn3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !kn3.f()) {
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
        eh2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        uq4 b2 = uq4.b();
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
        qk1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (mk1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            cx3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (nr1.a) {
                en3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = ku2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new eh2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, eh2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            eh2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (eh2.e eVar : eVarArr) {
                if (eVar != null) {
                    eh2.h(context).f(eVar);
                }
            }
        }
        eh2.h(context).k(ProcessUtils.isMainProcess());
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
            jw3.a().a(application);
            jw3.b().a(application, z, z2);
        }
    }
}
