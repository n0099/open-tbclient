package c.a.o0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.m1.i.a;
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.q;
import c.a.o0.a.v2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7321a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f7322b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f7323c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7324e;

        /* renamed from: c.a.o0.a.m1.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0292a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f7325e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f7326f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f7327g;

            public RunnableC0292a(a aVar, int i2, Bitmap bitmap, Rect rect) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), bitmap, rect};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7325e = i2;
                this.f7326f = bitmap;
                this.f7327g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.a.m1.i.a a2 = a.C0293a.a("simple_parser");
                    a2.c(this.f7325e);
                    if (a2.a(this.f7326f, this.f7327g)) {
                        return;
                    }
                    f.h();
                }
            }
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7324e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            c.a.o0.a.h0.g.g swanAppFragmentManager;
            c.a.o0.a.h0.g.f o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.o0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap p = n0.p();
            q.e().execute(new RunnableC0292a(this, c.d(o), p, c.b(p, o, c.a.o0.a.g1.f.V().C(this.f7324e))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1020168042, "Lc/a/o0/a/m1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1020168042, "Lc/a/o0/a/m1/f;");
                return;
            }
        }
        f7321a = k.f7049a;
        f7322b = "";
        f7323c = true;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            q0.X(new a(str));
        }
    }

    public static void c() {
        c.a.o0.a.h0.g.g W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            boolean z = f7321a;
            if (c.a.o0.a.j2.e.f() || (W = c.a.o0.a.g1.f.V().W()) == null) {
                return;
            }
            c.a.o0.a.h0.g.f o = W.o();
            c.a.o0.a.p.e.j.d dVar = null;
            if (o != null) {
                c.a.o0.a.p.e.b Z2 = o.Z2();
                if (Z2 == null) {
                    return;
                }
                c.a.o0.a.p.e.e l = Z2.l();
                if (l != null) {
                    dVar = l.N();
                } else {
                    dVar = Z2.N();
                }
            }
            if (dVar == null || dVar.f7864b <= 0) {
                return;
            }
            c.a.o0.a.j2.e.a(dVar);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || c.a.o0.a.j2.e.h()) {
            return;
        }
        c.a.o0.a.h0.g.f J = c.a.o0.a.g1.f.V().J();
        if (J == null) {
            boolean z = f7321a;
        } else if (!f(J)) {
            boolean z2 = f7321a;
            h();
        } else {
            boolean z3 = f7321a;
            b(J.e3());
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            f7322b = str;
        }
    }

    public static boolean f(c.a.o0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            boolean equals = TextUtils.equals(f7322b, fVar.e3());
            if (f7321a) {
                String str = "FirstPage: " + equals;
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f7323c : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            c.a.o0.a.j2.e.o(c.a.o0.a.a2.e.i() != null ? c.a.o0.a.a2.e.i().N() : null);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            if (f7321a) {
                String str = "on swan page change, isFromRoute : " + z;
            }
            if (z && c.a.o0.a.j2.e.j()) {
                boolean z2 = f7321a;
                return;
            }
            if (z) {
                f7323c = false;
            }
            if (!z) {
                d();
            }
            c.a.o0.a.j2.e.G();
            c();
            c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
            if (i2 == null || z) {
                return;
            }
            c.a.o0.a.j2.e.q(i2.N());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f7322b = "";
            f7323c = true;
        }
    }
}
