package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.am1;
import com.baidu.tieba.be2;
import com.baidu.tieba.df1;
import com.baidu.tieba.fl4;
import com.baidu.tieba.ji3;
import com.baidu.tieba.o53;
import com.baidu.tieba.or3;
import com.baidu.tieba.qb2;
import com.baidu.tieba.qh3;
import com.baidu.tieba.qi4;
import com.baidu.tieba.s82;
import com.baidu.tieba.vq3;
import com.baidu.tieba.wg4;
import com.baidu.tieba.wh3;
import com.baidu.tieba.wo2;
import com.baidu.tieba.xo2;
import com.baidu.tieba.zc4;
import com.baidu.tieba.ze1;
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
    public static class b implements qb2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                be2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.qb2.e
        public void a() {
            o53.M().post(new a(this));
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
                zc4.m(new wg4(0), new s82(null), xo2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = qi4.c(0);
        if (!c) {
            return;
        }
        ji3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !wh3.f()) {
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
        qb2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        fl4 b2 = fl4.b();
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
        df1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (ze1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            or3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (am1.a) {
                qh3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = wo2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new qb2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, qb2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            qb2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (qb2.e eVar : eVarArr) {
                if (eVar != null) {
                    qb2.h(context).f(eVar);
                }
            }
        }
        qb2.h(context).k(ProcessUtils.isMainProcess());
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
            vq3.a().a(application);
            vq3.b().a(application, z, z2);
        }
    }
}
