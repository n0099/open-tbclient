package c.a.q0.a.h0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.h;
import c.a.q0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static b f5872b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f5873c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.q0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.z2.g1.c f5874e;

        public a(c.a.q0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5874e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.a) {
                    String str2 = ">> default launchInfo: " + str;
                }
                this.f5874e.onCallback(f.f5872b.d(str));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216011114, "Lc/a/q0/a/h0/i/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216011114, "Lc/a/q0/a/h0/i/f;");
                return;
            }
        }
        a = k.a;
    }

    public static void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (bVar = f5872b) == null) {
            return;
        }
        bVar.c();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f.class) {
                if (f5872b != null) {
                    d.e();
                    f5872b.i();
                }
                f5872b = new b(null);
                if (f5873c != null) {
                    for (Map.Entry<String, String> entry : f5873c.entrySet()) {
                        f5872b.g(entry.getKey(), entry.getValue());
                    }
                    f5872b.l(true);
                    f5873c = null;
                }
                f5872b.h();
            }
        }
    }

    public static void e(c.a.q0.a.z2.g1.c<String> cVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, cVar) == null) || cVar == null || (bVar = f5872b) == null) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.a)) {
            if (a) {
                String str = ">> exception launchInfo: " + f5872b.a;
            }
            b bVar2 = f5872b;
            cVar.onCallback(bVar2.d(bVar2.a));
            return;
        }
        f5872b.e(new a(cVar));
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65542, null, z) == null) || c.a.q0.a.d2.d.J().l() == 1) {
            return;
        }
        d();
        l();
        j();
        k();
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            h(str, c.a.q0.a.z2.k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            b bVar = f5872b;
            if (bVar != null) {
                bVar.g(str, str2);
                return;
            }
            if (f5873c == null) {
                f5873c = new LinkedHashMap<>();
            }
            f5873c.put(str, str2);
        }
    }

    public static void i(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65545, null, i2) == null) || (bVar = f5872b) == null) {
            return;
        }
        bVar.k(i2);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.q0.a.h0.i.g.a.c.d().g();
            c.a.q0.a.h0.i.g.a.c.d().i();
        }
    }

    public static void k() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (bVar = f5872b) == null) {
            return;
        }
        bVar.m();
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.q0.a.h0.i.g.d.b.d().g();
            c.a.q0.a.h0.i.g.d.b.d().i();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5875b;

        /* renamed from: c  reason: collision with root package name */
        public int f5876c;

        /* renamed from: d  reason: collision with root package name */
        public long f5877d;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.q0.a.h0.i.h.c f5878e;

        /* loaded from: classes.dex */
        public class a extends c.a.q0.a.t0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f5879b;

            public a(b bVar, SwanAppActivity swanAppActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5879b = bVar;
                this.a = swanAppActivity;
            }

            @Override // c.a.q0.a.t0.a, c.a.q0.a.t0.b
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f5879b.j()) {
                    this.a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: c.a.q0.a.h0.i.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0312b implements c.a.q0.a.z2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.z2.g1.c f5880e;

            public C0312b(b bVar, c.a.q0.a.z2.g1.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5880e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                c.a.q0.a.z2.g1.c cVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (cVar = this.f5880e) == null) {
                    return;
                }
                cVar.onCallback(str);
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355557036, "Lc/a/q0/a/h0/i/f$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(355557036, "Lc/a/q0/a/h0/i/f$b;");
                    return;
                }
            }
            c.a.q0.a.c1.a.g0().n();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.f5875b = true;
            System.currentTimeMillis();
            this.f5876c = 0;
            this.f5877d = f();
            this.f5878e = new c.a.q0.a.h0.i.h.c();
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f5876c == 1) {
                if (!TextUtils.equals(c.a.q0.a.g1.f.U().T(), c.a())) {
                    if (f.a) {
                        String str = "current page: " + c.a.q0.a.g1.f.U().T();
                        String a2 = c.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton error first page: ");
                        if (a2 == null) {
                            a2 = "";
                        }
                        sb.append(a2);
                        sb.toString();
                        return;
                    }
                    return;
                }
                String C = c.a.q0.a.g1.f.U().C();
                if (TextUtils.isEmpty(C)) {
                    return;
                }
                c.a.q0.a.g1.f.U().m(C, new c.a.q0.a.o0.d.c("check-skeleton-status"));
            }
        }

        public String d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                StringBuilder sb = new StringBuilder(c.a.q0.a.c1.a.c().getText(h.swanapp_tip_cur_title));
                sb.append(str);
                String e2 = c.a.q0.a.h0.i.a.e();
                if (!TextUtils.isEmpty(e2)) {
                    sb.append(e2);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public void e(@NonNull c.a.q0.a.z2.g1.c<String> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                this.f5878e.e(new C0312b(this, cVar));
            }
        }

        public final long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
                if (a0 != null) {
                    return a0.V().l("launch_time", 0L);
                }
                return 0L;
            }
            return invokeV.longValue;
        }

        public void g(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                String str3 = StringUtils.LF + str2 + str;
                if (!TextUtils.isEmpty(this.a)) {
                    str3 = this.a + str3;
                }
                this.a = str3;
                c.a.q0.a.e0.d.k("SwanAppLaunchTips", str2 + str);
            }
        }

        public void h() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = c.a.q0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
                return;
            }
            activity.registerCallback(new a(this, activity));
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f5878e.i();
            }
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String f2 = !TextUtils.isEmpty(this.a) ? this.a : this.f5878e.f();
                if (!this.f5875b || TextUtils.isEmpty(f2)) {
                    return false;
                }
                c.a.q0.a.h0.i.a.h(this.f5877d, f2);
                this.f5875b = false;
                return true;
            }
            return invokeV.booleanValue;
        }

        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f5876c = i2;
            }
        }

        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.f5875b = z;
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.f5878e.h();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
