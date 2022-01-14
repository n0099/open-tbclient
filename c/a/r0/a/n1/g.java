package c.a.r0.a.n1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.n1.j.a;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f7854b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f7855c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7856e;

        /* renamed from: c.a.r0.a.n1.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0477a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f7857e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f7858f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f7859g;

            public RunnableC0477a(a aVar, int i2, Bitmap bitmap, Rect rect) {
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
                this.f7857e = i2;
                this.f7858f = bitmap;
                this.f7859g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.n1.j.a a = a.C0478a.a("simple_parser");
                    a.c(this.f7857e);
                    if (a.a(this.f7858f, this.f7859g)) {
                        return;
                    }
                    g.h();
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
            this.f7856e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            c.a.r0.a.h0.g.g swanAppFragmentManager;
            c.a.r0.a.h0.g.f o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.r0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap p = n0.p();
            q.f().execute(new RunnableC0477a(this, c.d(o), p, c.b(p, o, c.a.r0.a.g1.f.U().B(this.f7856e))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431551079, "Lc/a/r0/a/n1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431551079, "Lc/a/r0/a/n1/g;");
                return;
            }
        }
        a = k.a;
        f7854b = "";
        f7855c = true;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            q0.a0(new a(str));
        }
    }

    public static void c() {
        c.a.r0.a.h0.g.g V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            boolean z = a;
            if (c.a.r0.a.n2.e.f() || (V = c.a.r0.a.g1.f.U().V()) == null) {
                return;
            }
            c.a.r0.a.h0.g.f o = V.o();
            c.a.r0.a.p.e.j.d dVar = null;
            if (o != null) {
                c.a.r0.a.p.e.b i3 = o.i3();
                if (i3 == null) {
                    return;
                }
                c.a.r0.a.p.e.e l = i3.l();
                if (l != null) {
                    dVar = l.O();
                } else {
                    dVar = i3.O();
                }
            }
            if (dVar == null || dVar.f8159b <= 0) {
                return;
            }
            c.a.r0.a.n2.e.a(dVar);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || c.a.r0.a.n2.e.h()) {
            return;
        }
        c.a.r0.a.h0.g.f H = c.a.r0.a.g1.f.U().H();
        if (H == null) {
            boolean z = a;
        } else if (!f(H)) {
            boolean z2 = a;
            h();
        } else {
            boolean z3 = a;
            b(H.n3());
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            f7854b = str;
        }
    }

    public static boolean f(c.a.r0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            boolean equals = TextUtils.equals(f7854b, fVar.n3());
            if (a) {
                String str = "FirstPage: " + equals;
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f7855c : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            c.a.r0.a.n2.e.o(c.a.r0.a.d2.e.L() != null ? c.a.r0.a.d2.e.L().X() : null);
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
            if (a) {
                String str = "on swan page change, isFromRoute : " + z;
            }
            if (z && c.a.r0.a.n2.e.j()) {
                boolean z2 = a;
                return;
            }
            if (z) {
                f7855c = false;
            }
            if (!z) {
                d();
            }
            c.a.r0.a.n2.e.G();
            c();
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            if (L == null || z) {
                return;
            }
            c.a.r0.a.n2.e.q(L.X());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f7854b = "";
            f7855c = true;
        }
    }
}
