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
import com.repackage.a72;
import com.repackage.ad3;
import com.repackage.c42;
import com.repackage.ec4;
import com.repackage.em3;
import com.repackage.gd3;
import com.repackage.gk2;
import com.repackage.h84;
import com.repackage.hk2;
import com.repackage.jc1;
import com.repackage.jh1;
import com.repackage.l92;
import com.repackage.nc1;
import com.repackage.og4;
import com.repackage.td3;
import com.repackage.xm3;
import com.repackage.y03;
import com.repackage.yd4;
@Keep
/* loaded from: classes3.dex */
public class SwanAppInitHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SwanAppInitHelper";
    public static boolean sIsDelayInit;
    public static boolean sOnlyInitForLollipopAndAbove;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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
                h84.m(new ec4(0), new c42(null), hk2.i().o(null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a72.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
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
                    l92.c().e(null);
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

        @Override // com.repackage.a72.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y03.M().post(new a(this));
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
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (c = yd4.c(0))) {
            td3.k(new a(c), "asyncUpdateSwanAppCore by PMS");
        }
    }

    public static void delayInit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            sIsDelayInit = z;
        }
    }

    public static void doWebViewInit(Context context, a72.e... eVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, eVarArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                a72.h(context).f(new b());
            }
            if (eVarArr != null && eVarArr.length > 0) {
                for (a72.e eVar : eVarArr) {
                    if (eVar != null) {
                        a72.h(context).f(eVar);
                    }
                }
            }
            a72.h(context).k(ProcessUtils.isMainProcess());
        }
    }

    public static boolean entranceOK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? !sOnlyInitForLollipopAndAbove || gd3.f() : invokeV.booleanValue;
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
            nc1.b(application);
        }
    }

    public static void initStatisticsModule(Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, application) == null) && jc1.g()) {
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
                xm3.d(application).i();
            }
            initWebView(application);
            if (ProcessUtils.isMainProcess()) {
                asyncUpdateSwanAppCore();
                if (jh1.a) {
                    ad3.d(0, 1);
                }
            }
        }
    }

    public static void initWebView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            boolean d = gk2.w0().d();
            WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
            WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d, false);
            doWebViewInit(context, new a72.e[0]);
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
            a72.h(AppRuntime.getAppContext()).n();
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
            og4 b2 = og4.b();
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
                em3.a().a(application);
                em3.b().a(application, z, z2);
            }
        }
    }
}
