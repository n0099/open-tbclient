package c.a.r0.a.u.e.i;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.n.c;
import c.a.r0.a.n2.c;
import c.a.r0.a.z2.l0;
import c.a.r0.a.z2.q;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8NetFunctionTable;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestSettings;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static int f9240b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9241c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements ValueCallback<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ V8Engine a;

        /* renamed from: c.a.r0.a.u.e.i.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0588a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f9242e;

            public RunnableC0588a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9242e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetRequest netRequest = new NetRequest();
                    NetRequestSettings netRequestSettings = new NetRequestSettings();
                    netRequestSettings.mTimeout = 60000;
                    netRequestSettings.mShouldNeverClearReferer = true;
                    netRequestSettings.mLoadDoNotSendCookies = true;
                    netRequest.setRequestInterceptor(new d());
                    netRequest.setRedirectInterceptor(new k());
                    netRequest.addObserver(new f());
                    netRequest.setNetRequestSettings(netRequestSettings);
                    int javaNetRequest = this.f9242e.a.setJavaNetRequest(netRequest);
                    boolean unused = e.f9241c = javaNetRequest == 0;
                    if (e.f9241c) {
                        return;
                    }
                    int unused2 = e.f9240b = 0;
                    e.g(javaNetRequest);
                    c.a.r0.a.e0.d.c("ChromeNetManager", "setJavaNetRequest fail, code=" + javaNetRequest);
                }
            }
        }

        public a(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Engine};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v8Engine;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                this.a.runOnJSThread(new RunnableC0588a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9243e;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9243e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b bVar = new c.b(10016);
                bVar.l(String.valueOf(this.f9243e));
                bVar.h(c.a.r0.a.d2.d.J().getAppId());
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536516377, "Lc/a/r0/a/u/e/i/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(536516377, "Lc/a/r0/a/u/e/i/e;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
        f9240b = -1;
        f9241c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.r0.a.z2.j.e() && h() : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.a.r0.a.c1.a.g0().z() == 2 : invokeV.booleanValue;
    }

    public static void f(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, v8Engine) == null) {
            if (!d()) {
                c.a.r0.a.e0.d.k("ChromeNetManager", "Not Used ChromeNet");
            } else {
                V8NetFunctionTable.addOnCronetThreadInitializedListener(new a(v8Engine));
            }
        }
    }

    public static void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            q.f().execute(new b(i2));
        }
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f9240b == -1) {
                f9240b = (!j() || l0.f("3.300.0")) ? 0 : 1;
            }
            return f9240b == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f9241c : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.r0.a.c1.a.g0().z() >= 1 : invokeV.booleanValue;
    }

    public static void k(@Nullable SwanAppConfigData swanAppConfigData) {
        c.a aVar;
        int i2;
        c.a.r0.a.h0.l.a W;
        NetRequest p0;
        NetRequestSettings netRequestSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, swanAppConfigData) == null) || !d() || swanAppConfigData == null || (aVar = swanAppConfigData.f39374h) == null || (i2 = aVar.f5711b) <= 0 || (W = c.a.r0.a.h0.u.g.U().W()) == null || !(W.g() instanceof c.a.r0.a.l0.a) || (p0 = ((c.a.r0.a.l0.a) W.g()).p0()) == null || (netRequestSettings = p0.getNetRequestSettings()) == null) {
            return;
        }
        netRequestSettings.mTimeout = i2;
        if (a) {
            String str = "settings.mTimeout=" + i2;
        }
    }
}
