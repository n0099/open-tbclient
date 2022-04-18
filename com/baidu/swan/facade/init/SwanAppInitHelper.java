package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.ubc.OpenStatisticIPCManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebViewFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.repackage.dd3;
import com.repackage.hm3;
import com.repackage.i03;
import com.repackage.id4;
import com.repackage.k62;
import com.repackage.kc3;
import com.repackage.m32;
import com.repackage.ob4;
import com.repackage.ol3;
import com.repackage.qc3;
import com.repackage.qj2;
import com.repackage.r74;
import com.repackage.rj2;
import com.repackage.tg1;
import com.repackage.ub1;
import com.repackage.v82;
import com.repackage.yb1;
import com.repackage.zf4;
@Keep
/* loaded from: classes2.dex */
public class SwanAppInitHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SwanAppInitHelper";
    public static boolean sIsDelayInit;
    public static boolean sOnlyInitForLollipopAndAbove;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a) {
                r74.m(new ob4(0), new m32(null), rj2.i().p(null));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements k62.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    v82.c().e(null);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.k62.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i03.L().post(new a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-387673689, "Lcom/baidu/swan/facade/init/SwanAppInitHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-387673689, "Lcom/baidu/swan/facade/init/SwanAppInitHelper;");
        }
    }

    public SwanAppInitHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (c = id4.c(0))) {
            dd3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
        }
    }

    public static void delayInit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            sIsDelayInit = z;
        }
    }

    public static void doWebViewInit(Context context, k62.e... eVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, eVarArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                k62.h(context).f(new b());
            }
            if (eVarArr != null && eVarArr.length > 0) {
                for (k62.e eVar : eVarArr) {
                    if (eVar != null) {
                        k62.h(context).f(eVar);
                    }
                }
            }
            k62.h(context).k(ProcessUtils.isMainProcess());
        }
    }

    public static boolean entranceOK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? !sOnlyInitForLollipopAndAbove || qc3.f() : invokeV.booleanValue;
    }

    public static void initConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            uploadLastData();
        }
    }

    public static void initContext(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, application) == null) {
            initRuntimeContext(application);
        }
    }

    public static void initModules(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, application) == null) {
            initModules(application, sIsDelayInit);
        }
    }

    public static void initRuntimeContext(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, application) == null) {
            AppRuntimeInit.onApplicationattachBaseContext(application);
            yb1.b(application);
        }
    }

    public static void initStatisticsModule(Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, application) == null) && ub1.g()) {
            OpenStatisticIPCManager.a();
            initConfig();
        }
    }

    public static void initSwanAppModule(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, application) == null) {
            if (!Fresco.hasBeenInitialized()) {
                Fresco.initialize(application);
            }
            if (ProcessUtils.isMainProcess()) {
                hm3.d(application).i();
            }
            initWebView(application);
            if (ProcessUtils.isMainProcess()) {
                asyncUpdateSwanAppCore();
                if (tg1.a) {
                    kc3.d(0, 1);
                }
            }
        }
    }

    public static void initWebView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            boolean d = qj2.w0().d();
            WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
            WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
            doWebViewInit(context, new k62.e[0]);
        }
    }

    public static boolean isDelayInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? sIsDelayInit : invokeV.booleanValue;
    }

    public static boolean isProcessNeedInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? ProcessUtils.isMainProcess() || ProcessUtils.isSwanProcess() : invokeV.booleanValue;
    }

    public static void onTerminate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            k62.h(AppRuntime.getAppContext()).n();
        }
    }

    public static void onlyInitForLollipopAndAbove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            sOnlyInitForLollipopAndAbove = z;
        }
    }

    public static void uploadLastData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            zf4 b2 = zf4.b();
            b2.h();
            b2.i();
        }
    }

    public static void initModules(Application application, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, application, z) == null) {
            initModules(application, z, sOnlyInitForLollipopAndAbove);
        }
    }

    public static void initModules(Application application, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{application, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            onlyInitForLollipopAndAbove(z2);
            delayInit(z);
            if (entranceOK() && !isDelayInit() && isProcessNeedInit()) {
                initStatisticsModule(application);
                initSwanAppModule(application);
                ol3.a().a(application);
                ol3.b().a(application, z, z2);
            }
        }
    }
}
