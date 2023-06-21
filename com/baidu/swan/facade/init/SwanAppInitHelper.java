package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.ai2;
import com.baidu.tieba.ao3;
import com.baidu.tieba.ap4;
import com.baidu.tieba.cf2;
import com.baidu.tieba.fx3;
import com.baidu.tieba.gn4;
import com.baidu.tieba.go3;
import com.baidu.tieba.gv2;
import com.baidu.tieba.hv2;
import com.baidu.tieba.il1;
import com.baidu.tieba.jj4;
import com.baidu.tieba.js1;
import com.baidu.tieba.lk2;
import com.baidu.tieba.ml1;
import com.baidu.tieba.qr4;
import com.baidu.tieba.to3;
import com.baidu.tieba.yb3;
import com.baidu.tieba.yx3;
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
    public static class b implements ai2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                lk2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.ai2.e
        public void a() {
            yb3.M().post(new a(this));
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
                jj4.m(new gn4(0), new cf2(null), hv2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = ap4.c(0);
        if (!c) {
            return;
        }
        to3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !go3.f()) {
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
        ai2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        qr4 b2 = qr4.b();
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
        ml1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (il1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            yx3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (js1.a) {
                ao3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = gv2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new ai2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, ai2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            ai2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (ai2.e eVar : eVarArr) {
                if (eVar != null) {
                    ai2.h(context).f(eVar);
                }
            }
        }
        ai2.h(context).k(ProcessUtils.isMainProcess());
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
            fx3.a().a(application);
            fx3.b().a(application, z, z2);
        }
    }
}
