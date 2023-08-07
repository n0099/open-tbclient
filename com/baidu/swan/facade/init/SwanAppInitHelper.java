package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.tieba.be2;
import com.baidu.tieba.ew3;
import com.baidu.tieba.fm4;
import com.baidu.tieba.fn3;
import com.baidu.tieba.fu2;
import com.baidu.tieba.gu2;
import com.baidu.tieba.hk1;
import com.baidu.tieba.ii4;
import com.baidu.tieba.ir1;
import com.baidu.tieba.kj2;
import com.baidu.tieba.lk1;
import com.baidu.tieba.pq4;
import com.baidu.tieba.sn3;
import com.baidu.tieba.xa3;
import com.baidu.tieba.xw3;
import com.baidu.tieba.zg2;
import com.baidu.tieba.zm3;
import com.baidu.tieba.zn4;
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
    public static class b implements zg2.e {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                kj2.c().e(null);
            }
        }

        @Override // com.baidu.tieba.zg2.e
        public void a() {
            xa3.M().post(new a(this));
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
                ii4.m(new fm4(0), new be2(null), gu2.i().o(null));
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c = zn4.c(0);
        if (!c) {
            return;
        }
        sn3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
    }

    public static boolean entranceOK() {
        if (sOnlyInitForLollipopAndAbove && !fn3.f()) {
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
        zg2.h(AppRuntime.getAppContext()).n();
    }

    public static void uploadLastData() {
        pq4 b2 = pq4.b();
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
        lk1.b(application);
    }

    public static void initStatisticsModule(Application application) {
        if (hk1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(application);
        }
        if (ProcessUtils.isMainProcess()) {
            xw3.d(application).i();
        }
        initWebView(application);
        if (ProcessUtils.isMainProcess()) {
            asyncUpdateSwanAppCore();
            if (ir1.a) {
                zm3.d(0, 1);
            }
        }
    }

    public static void initWebView(Context context) {
        boolean d = fu2.w0().d();
        WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
        WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
        doWebViewInit(context, new zg2.e[0]);
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        sOnlyInitForLollipopAndAbove = z;
    }

    public static void doWebViewInit(Context context, zg2.e... eVarArr) {
        if (ProcessUtils.isMainProcess()) {
            zg2.h(context).f(new b());
        }
        if (eVarArr != null && eVarArr.length > 0) {
            for (zg2.e eVar : eVarArr) {
                if (eVar != null) {
                    zg2.h(context).f(eVar);
                }
            }
        }
        zg2.h(context).k(ProcessUtils.isMainProcess());
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
            ew3.a().a(application);
            ew3.b().a(application, z, z2);
        }
    }
}
