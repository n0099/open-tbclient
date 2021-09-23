package c.a.f0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.j0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c.a.j0.a.b a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            b.C0076b c0076b = new b.C0076b(hVar.e(), hVar.f3420g);
            c0076b.w("rsplash");
            c0076b.l(hVar.f3419f == 1);
            c0076b.h(b());
            c0076b.p(c());
            c0076b.r(hVar.f3419f == 1);
            c0076b.q(d(hVar.m));
            c0076b.E(hVar.n * 1000);
            c0076b.C(1);
            c0076b.H(SplashStyleRecorder.a());
            c0076b.i(5);
            c0076b.A(false);
            c0076b.c(hVar.l);
            c0076b.e(25);
            c0076b.d(13);
            c0076b.D(72);
            c0076b.B(30);
            c0076b.G(68);
            c0076b.F(30);
            c0076b.k(17);
            c0076b.t(hVar.y);
            c0076b.z(hVar.z == 1);
            c0076b.b(hVar.A);
            c0076b.s(hVar.d());
            c0076b.u("跳转详情页或第三方应用");
            c0076b.v(hVar.g() ? 47 : b() + 39);
            c0076b.m(hVar.G);
            c0076b.o(hVar.F);
            c0076b.n(hVar.H);
            return c0076b.a();
        }
        return (c.a.j0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c.a.f0.a.b.a.f3338a.get() == null || c.a.f0.a.b.a.f3338a.get().d() == 0) {
                return 120;
            }
            return c.a.f0.a.b.a.f3338a.get().d();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c.a.f0.a.b.a.f3338a.get() == null) {
                return -1;
            }
            return c.a.f0.a.b.a.f3338a.get().e();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (c.a.f0.a.b.a.f3338a.get() == null) {
                return -1;
            }
            if (i2 == 1) {
                return c.a.f0.a.b.a.f3338a.get().E();
            }
            return c.a.f0.a.b.a.f3338a.get().B();
        }
        return invokeI.intValue;
    }
}
