package b.a.p0.a.n1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.n1.j.a;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
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
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7241a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f7242b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f7243c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7244e;

        /* renamed from: b.a.p0.a.n1.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0328a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f7245e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f7246f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f7247g;

            public RunnableC0328a(a aVar, int i2, Bitmap bitmap, Rect rect) {
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
                this.f7245e = i2;
                this.f7246f = bitmap;
                this.f7247g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.n1.j.a a2 = a.C0329a.a("simple_parser");
                    a2.c(this.f7245e);
                    if (a2.a(this.f7246f, this.f7247g)) {
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
            this.f7244e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            b.a.p0.a.h0.g.g swanAppFragmentManager;
            b.a.p0.a.h0.g.f o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap p = n0.p();
            q.f().execute(new RunnableC0328a(this, c.d(o), p, c.b(p, o, b.a.p0.a.g1.f.U().B(this.f7244e))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330136714, "Lb/a/p0/a/n1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330136714, "Lb/a/p0/a/n1/g;");
                return;
            }
        }
        f7241a = k.f6863a;
        f7242b = "";
        f7243c = true;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            q0.a0(new a(str));
        }
    }

    public static void c() {
        b.a.p0.a.h0.g.g V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            boolean z = f7241a;
            if (b.a.p0.a.n2.e.f() || (V = b.a.p0.a.g1.f.U().V()) == null) {
                return;
            }
            b.a.p0.a.h0.g.f o = V.o();
            b.a.p0.a.p.e.j.d dVar = null;
            if (o != null) {
                b.a.p0.a.p.e.b l3 = o.l3();
                if (l3 == null) {
                    return;
                }
                b.a.p0.a.p.e.e l = l3.l();
                if (l != null) {
                    dVar = l.O();
                } else {
                    dVar = l3.O();
                }
            }
            if (dVar == null || dVar.f7608b <= 0) {
                return;
            }
            b.a.p0.a.n2.e.a(dVar);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || b.a.p0.a.n2.e.h()) {
            return;
        }
        b.a.p0.a.h0.g.f H = b.a.p0.a.g1.f.U().H();
        if (H == null) {
            boolean z = f7241a;
        } else if (!f(H)) {
            boolean z2 = f7241a;
            h();
        } else {
            boolean z3 = f7241a;
            b(H.q3());
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            f7242b = str;
        }
    }

    public static boolean f(b.a.p0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            boolean equals = TextUtils.equals(f7242b, fVar.q3());
            if (f7241a) {
                String str = "FirstPage: " + equals;
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f7243c : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            b.a.p0.a.n2.e.o(b.a.p0.a.d2.e.L() != null ? b.a.p0.a.d2.e.L().X() : null);
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
            if (f7241a) {
                String str = "on swan page change, isFromRoute : " + z;
            }
            if (z && b.a.p0.a.n2.e.j()) {
                boolean z2 = f7241a;
                return;
            }
            if (z) {
                f7243c = false;
            }
            if (!z) {
                d();
            }
            b.a.p0.a.n2.e.G();
            c();
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            if (L == null || z) {
                return;
            }
            b.a.p0.a.n2.e.q(L.X());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f7242b = "";
            f7243c = true;
        }
    }
}
