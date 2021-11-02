package b.a.p0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.m1.i.a;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
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
    public static final boolean f6666a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f6667b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f6668c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6669e;

        /* renamed from: b.a.p0.a.m1.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0289a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f6670e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f6671f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f6672g;

            public RunnableC0289a(a aVar, int i2, Bitmap bitmap, Rect rect) {
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
                this.f6670e = i2;
                this.f6671f = bitmap;
                this.f6672g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.m1.i.a a2 = a.C0290a.a("simple_parser");
                    a2.c(this.f6670e);
                    if (a2.a(this.f6671f, this.f6672g)) {
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
            this.f6669e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            b.a.p0.a.h0.g.g swanAppFragmentManager;
            b.a.p0.a.h0.g.f o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap p = n0.p();
            q.e().execute(new RunnableC0289a(this, c.d(o), p, c.b(p, o, b.a.p0.a.g1.f.T().B(this.f6669e))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1329213162, "Lb/a/p0/a/m1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1329213162, "Lb/a/p0/a/m1/f;");
                return;
            }
        }
        f6666a = k.f6397a;
        f6667b = "";
        f6668c = true;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            q0.X(new a(str));
        }
    }

    public static void c() {
        b.a.p0.a.h0.g.g U;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            boolean z = f6666a;
            if (b.a.p0.a.j2.e.f() || (U = b.a.p0.a.g1.f.T().U()) == null) {
                return;
            }
            b.a.p0.a.h0.g.f o = U.o();
            b.a.p0.a.p.e.j.d dVar = null;
            if (o != null) {
                b.a.p0.a.p.e.b V2 = o.V2();
                if (V2 == null) {
                    return;
                }
                b.a.p0.a.p.e.e k = V2.k();
                if (k != null) {
                    dVar = k.M();
                } else {
                    dVar = V2.M();
                }
            }
            if (dVar == null || dVar.f7193b <= 0) {
                return;
            }
            b.a.p0.a.j2.e.a(dVar);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || b.a.p0.a.j2.e.h()) {
            return;
        }
        b.a.p0.a.h0.g.f H = b.a.p0.a.g1.f.T().H();
        if (H == null) {
            boolean z = f6666a;
        } else if (!f(H)) {
            boolean z2 = f6666a;
            h();
        } else {
            boolean z3 = f6666a;
            b(H.a3());
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            f6667b = str;
        }
    }

    public static boolean f(b.a.p0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            boolean equals = TextUtils.equals(f6667b, fVar.a3());
            if (f6666a) {
                String str = "FirstPage: " + equals;
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f6668c : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            b.a.p0.a.j2.e.o(b.a.p0.a.a2.e.i() != null ? b.a.p0.a.a2.e.i().M() : null);
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
            if (f6666a) {
                String str = "on swan page change, isFromRoute : " + z;
            }
            if (z && b.a.p0.a.j2.e.j()) {
                boolean z2 = f6666a;
                return;
            }
            if (z) {
                f6668c = false;
            }
            if (!z) {
                d();
            }
            b.a.p0.a.j2.e.G();
            c();
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null || z) {
                return;
            }
            b.a.p0.a.j2.e.q(i2.M());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f6667b = "";
            f6668c = true;
        }
    }
}
