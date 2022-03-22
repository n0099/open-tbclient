package c.a.n0.a.x.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static b f7091b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f7092c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.n0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.p2.g1.c a;

        public a(c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.a) {
                    Log.d("SwanAppLaunchTips", ">> default launchInfo: " + str);
                }
                this.a.onCallback(f.f7091b.d(str));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622827673, "Lc/a/n0/a/x/i/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622827673, "Lc/a/n0/a/x/i/f;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (bVar = f7091b) == null) {
            return;
        }
        bVar.c();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f.class) {
                if (f7091b != null) {
                    d.e();
                    f7091b.i();
                }
                f7091b = new b(null);
                if (f7092c != null) {
                    for (Map.Entry<String, String> entry : f7092c.entrySet()) {
                        f7091b.g(entry.getKey(), entry.getValue());
                    }
                    f7091b.l(true);
                    f7092c = null;
                }
                f7091b.h();
            }
        }
    }

    public static void e(c.a.n0.a.p2.g1.c<String> cVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, cVar) == null) || cVar == null || (bVar = f7091b) == null) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.a)) {
            if (a) {
                Log.d("SwanAppLaunchTips", ">> exception launchInfo: " + f7091b.a);
            }
            b bVar2 = f7091b;
            cVar.onCallback(bVar2.d(bVar2.a));
            return;
        }
        f7091b.e(new a(cVar));
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65542, null, z) == null) || c.a.n0.a.t1.d.J().l() == 1) {
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
            h(str, k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            b bVar = f7091b;
            if (bVar != null) {
                bVar.g(str, str2);
                return;
            }
            if (f7092c == null) {
                f7092c = new LinkedHashMap<>();
            }
            f7092c.put(str, str2);
        }
    }

    public static void i(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65545, null, i) == null) || (bVar = f7091b) == null) {
            return;
        }
        bVar.k(i);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.n0.a.x.i.g.a.c.d().g();
            c.a.n0.a.x.i.g.a.c.d().i();
        }
    }

    public static void k() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (bVar = f7091b) == null) {
            return;
        }
        bVar.m();
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.n0.a.x.i.g.d.b.d().g();
            c.a.n0.a.x.i.g.d.b.d().i();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7093b;

        /* renamed from: c  reason: collision with root package name */
        public int f7094c;

        /* renamed from: d  reason: collision with root package name */
        public long f7095d;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.n0.a.x.i.h.c f7096e;

        /* loaded from: classes.dex */
        public class a extends c.a.n0.a.j0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppActivity a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f7097b;

            public a(b bVar, SwanAppActivity swanAppActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7097b = bVar;
                this.a = swanAppActivity;
            }

            @Override // c.a.n0.a.j0.a, c.a.n0.a.j0.b
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f7097b.j()) {
                    this.a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: c.a.n0.a.x.i.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0537b implements c.a.n0.a.p2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.p2.g1.c a;

            public C0537b(b bVar, c.a.n0.a.p2.g1.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                c.a.n0.a.p2.g1.c cVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (cVar = this.a) == null) {
                    return;
                }
                cVar.onCallback(str);
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1536958615, "Lc/a/n0/a/x/i/f$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1536958615, "Lc/a/n0/a/x/i/f$b;");
                    return;
                }
            }
            c.a.n0.a.s0.a.g0().n();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.f7093b = true;
            System.currentTimeMillis();
            this.f7094c = 0;
            this.f7095d = f();
            this.f7096e = new c.a.n0.a.x.i.h.c();
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f7094c == 1) {
                if (!TextUtils.equals(c.a.n0.a.w0.f.U().T(), c.a())) {
                    if (f.a) {
                        Log.d("SwanAppLaunchTips", "current page is not skeleton error first page");
                        Log.d("SwanAppLaunchTips", "current page: " + c.a.n0.a.w0.f.U().T());
                        String a2 = c.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton error first page: ");
                        if (a2 == null) {
                            a2 = "";
                        }
                        sb.append(a2);
                        Log.d("SwanAppLaunchTips", sb.toString());
                        return;
                    }
                    return;
                }
                String C = c.a.n0.a.w0.f.U().C();
                if (TextUtils.isEmpty(C)) {
                    return;
                }
                c.a.n0.a.w0.f.U().m(C, new c.a.n0.a.e0.d.c("check-skeleton-status"));
            }
        }

        public String d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                StringBuilder sb = new StringBuilder(c.a.n0.a.s0.a.c().getText(R.string.obfuscated_res_0x7f0f12db));
                sb.append(str);
                String e2 = c.a.n0.a.x.i.a.e();
                if (!TextUtils.isEmpty(e2)) {
                    sb.append(e2);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public void e(@NonNull c.a.n0.a.p2.g1.c<String> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                this.f7096e.e(new C0537b(this, cVar));
            }
        }

        public final long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
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
                String str3 = "\n" + str2 + str;
                if (!TextUtils.isEmpty(this.a)) {
                    str3 = this.a + str3;
                }
                this.a = str3;
                c.a.n0.a.u.d.k("SwanAppLaunchTips", str2 + str);
            }
        }

        public void h() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = c.a.n0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
                return;
            }
            activity.registerCallback(new a(this, activity));
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f7096e.i();
            }
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String f2 = !TextUtils.isEmpty(this.a) ? this.a : this.f7096e.f();
                if (!this.f7093b || TextUtils.isEmpty(f2)) {
                    return false;
                }
                c.a.n0.a.x.i.a.h(this.f7095d, f2);
                this.f7093b = false;
                return true;
            }
            return invokeV.booleanValue;
        }

        public void k(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.f7094c = i;
            }
        }

        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.f7093b = z;
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.f7096e.h();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
