package b.a.p0.a.u.e.i;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.n.c;
import b.a.p0.a.n2.c;
import b.a.p0.a.z2.l0;
import b.a.p0.a.z2.q;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8701a;

    /* renamed from: b  reason: collision with root package name */
    public static int f8702b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8703c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements ValueCallback<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ V8Engine f8704a;

        /* renamed from: b.a.p0.a.u.e.i.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0430a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8705e;

            public RunnableC0430a(a aVar) {
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
                this.f8705e = aVar;
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
                    int javaNetRequest = this.f8705e.f8704a.setJavaNetRequest(netRequest);
                    boolean unused = e.f8703c = javaNetRequest == 0;
                    if (e.f8703c) {
                        return;
                    }
                    int unused2 = e.f8702b = 0;
                    e.g(javaNetRequest);
                    b.a.p0.a.e0.d.c("ChromeNetManager", "setJavaNetRequest fail, code=" + javaNetRequest);
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
            this.f8704a = v8Engine;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                this.f8704a.runOnJSThread(new RunnableC0430a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8706e;

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
            this.f8706e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b bVar = new c.b(10016);
                bVar.l(String.valueOf(this.f8706e));
                bVar.h(b.a.p0.a.d2.d.J().getAppId());
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229987306, "Lb/a/p0/a/u/e/i/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229987306, "Lb/a/p0/a/u/e/i/e;");
                return;
            }
        }
        f8701a = b.a.p0.a.k.f6863a;
        f8702b = -1;
        f8703c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b.a.p0.a.z2.j.e() && h() : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.a.p0.a.c1.a.g0().z() == 2 : invokeV.booleanValue;
    }

    public static void f(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, v8Engine) == null) {
            if (!d()) {
                b.a.p0.a.e0.d.k("ChromeNetManager", "Not Used ChromeNet");
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
            if (f8702b == -1) {
                f8702b = (!j() || l0.f("3.300.0")) ? 0 : 1;
            }
            return f8702b == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f8703c : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b.a.p0.a.c1.a.g0().z() >= 1 : invokeV.booleanValue;
    }

    public static void k(@Nullable SwanAppConfigData swanAppConfigData) {
        c.a aVar;
        int i2;
        b.a.p0.a.h0.l.a W;
        NetRequest p0;
        NetRequestSettings netRequestSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, swanAppConfigData) == null) || !d() || swanAppConfigData == null || (aVar = swanAppConfigData.f45033h) == null || (i2 = aVar.f4511b) <= 0 || (W = b.a.p0.a.h0.u.g.U().W()) == null || !(W.g() instanceof b.a.p0.a.l0.a) || (p0 = ((b.a.p0.a.l0.a) W.g()).p0()) == null || (netRequestSettings = p0.getNetRequestSettings()) == null) {
            return;
        }
        netRequestSettings.mTimeout = i2;
        if (f8701a) {
            String str = "settings.mTimeout=" + i2;
        }
    }
}
