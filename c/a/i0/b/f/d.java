package c.a.i0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.m0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c.a.m0.a.b a(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            b.C0191b c0191b = new b.C0191b(gVar.e(), gVar.f3844g);
            c0191b.t("rsplash");
            c0191b.i(gVar.f3843f == 1);
            c0191b.f(b());
            c0191b.m(c());
            c0191b.o(gVar.f3843f == 1);
            c0191b.n(d(gVar.m));
            c0191b.z(gVar.n * 1000);
            c0191b.x(1);
            c0191b.C(SplashStyleRecorder.a());
            c0191b.g(5);
            c0191b.v(false);
            c0191b.c(gVar.l);
            c0191b.e(25);
            c0191b.d(13);
            c0191b.y(72);
            c0191b.w(30);
            c0191b.B(68);
            c0191b.A(30);
            c0191b.h(17);
            c0191b.q(gVar.y);
            c0191b.u(gVar.z == 1);
            c0191b.b(gVar.A);
            c0191b.p(gVar.d());
            c0191b.r("跳转详情页或第三方应用");
            c0191b.s(gVar.g() ? 47 : b() + 39);
            c0191b.j(gVar.G);
            c0191b.l(gVar.F);
            c0191b.k(gVar.H);
            return c0191b.a();
        }
        return (c.a.m0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.i0.a.b.d.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.i0.a.b.d.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 == 1) {
                return c.a.i0.a.b.d.a().h();
            }
            return c.a.i0.a.b.d.a().g();
        }
        return invokeI.intValue;
    }
}
