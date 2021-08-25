package com.baidu.swan.facade.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.b.a.e;
import c.a.o0.a.a2.d;
import c.a.o0.a.h0.m.i;
import c.a.o0.a.h0.s.b;
import c.a.o0.a.k;
import c.a.o0.a.n0.f;
import c.a.o0.a.v2.q;
import c.a.o0.n.i.m.h;
import c.a.o0.r.p;
import com.baidu.mobads.container.util.AdIconUtil;
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
@Keep
/* loaded from: classes6.dex */
public class SwanAppInitHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SwanAppInitHelper";
    public static boolean sIsDelayInit;
    public static boolean sOnlyInitForLollipopAndAbove;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46686e;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46686e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46686e) {
                c.a.o0.n.b.k(new h(0), new i(null), c.a.o0.a.c1.b.i().p(null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f.c().e(null);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.a.h0.s.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.i().post(new a(this));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void asyncUpdateSwanAppCore() {
        boolean c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (c2 = c.a.o0.n.n.a.c(0))) {
            q.j(new a(c2), "asyncUpdateSwanAppCore by PMS");
        }
    }

    public static void delayInit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            sIsDelayInit = z;
        }
    }

    public static void doWebViewInit(Context context, b.c... cVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, cVarArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                c.a.o0.a.h0.s.b.g(context).e(new b());
            }
            if (cVarArr != null && cVarArr.length > 0) {
                for (b.c cVar : cVarArr) {
                    if (cVar != null) {
                        c.a.o0.a.h0.s.b.g(context).e(cVar);
                    }
                }
            }
            c.a.o0.a.h0.s.b.g(context).j(ProcessUtils.isMainProcess());
        }
    }

    public static boolean entranceOK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? !sOnlyInitForLollipopAndAbove || c.a.o0.a.v2.d.f() : invokeV.booleanValue;
    }

    public static void initConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
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
            e.b(application);
        }
    }

    public static void initStatisticsModule(Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, application) == null) && c.a.h0.b.a.a.g()) {
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
                c.a.o0.e.k.b.d(application).i();
            }
            initWebView(application);
            if (ProcessUtils.isMainProcess()) {
                asyncUpdateSwanAppCore();
                if (k.f7049a) {
                    c.a.o0.a.t2.a.d(0, 1);
                }
            }
        }
    }

    public static void initWebView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            boolean d2 = c.a.o0.a.c1.a.n0().d();
            WebViewFactory.setAbTestInterface(new DefaultSailorAbTest());
            WebViewFactory.initOnAppStart(AppRuntime.getAppContext(), d2, false);
            doWebViewInit(context, new b.c[0]);
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
            c.a.o0.a.h0.s.b.g(AppRuntime.getAppContext()).m();
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
            p b2 = p.b();
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
                c.a.o0.e.f.a().a(application);
                c.a.o0.e.f.b().a(application, z, z2);
            }
        }
    }
}
