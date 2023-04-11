package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.at3;
import com.baidu.tieba.bj4;
import com.baidu.tieba.bk3;
import com.baidu.tieba.br2;
import com.baidu.tieba.cr2;
import com.baidu.tieba.ef4;
import com.baidu.tieba.eo1;
import com.baidu.tieba.fj1;
import com.baidu.tieba.gg2;
import com.baidu.tieba.jj1;
import com.baidu.tieba.ln4;
import com.baidu.tieba.ok3;
import com.baidu.tieba.t73;
import com.baidu.tieba.tt3;
import com.baidu.tieba.vd2;
import com.baidu.tieba.vj3;
import com.baidu.tieba.vk4;
import com.baidu.tieba.xa2;
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
    public static class b implements vd2.e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                gg2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.vd2.e
        public void a() {
            t73.M().post(new a(this));
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
                ef4.m(new bj4(0), new xa2(null), cr2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = vk4.c(0);
        if (!c) {
            return;
        }
        ok3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !bk3.f()) {
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
        vd2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        ln4 b2 = ln4.b();
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
        jj1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (fj1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            tt3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (eo1.a) {
                vj3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = br2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new vd2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, vd2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            vd2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (vd2.e eVar : eVarArr) {
                if (eVar != null) {
                    vd2.h(context).f(eVar);
                }
            }
        }
        vd2.h(context).k(ProcessUtils.isMainProcess());
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
            at3.a().a(application);
            at3.b().a(application, z, z2);
        }
    }
}
