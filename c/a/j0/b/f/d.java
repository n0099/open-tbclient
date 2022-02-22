package c.a.j0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.n0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c.a.n0.a.b a(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            b.C0217b c0217b = new b.C0217b(gVar.e(), gVar.f4296g);
            c0217b.t("rsplash");
            c0217b.i(gVar.f4295f == 1);
            c0217b.f(b());
            c0217b.m(c());
            c0217b.o(gVar.f4295f == 1);
            c0217b.n(d(gVar.m));
            c0217b.z(gVar.n * 1000);
            c0217b.x(1);
            c0217b.C(SplashStyleRecorder.a());
            c0217b.g(5);
            c0217b.v(false);
            c0217b.c(gVar.l);
            c0217b.e(25);
            c0217b.d(13);
            c0217b.y(72);
            c0217b.w(30);
            c0217b.B(68);
            c0217b.A(30);
            c0217b.h(17);
            c0217b.q(gVar.y);
            c0217b.u(gVar.z == 1);
            c0217b.b(gVar.A);
            c0217b.p(gVar.d());
            c0217b.r("跳转详情页或第三方应用");
            c0217b.s(gVar.g() ? 47 : b() + 39);
            c0217b.j(gVar.G);
            c0217b.l(gVar.F);
            c0217b.k(gVar.H);
            return c0217b.a();
        }
        return (c.a.n0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.j0.a.b.d.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.j0.a.b.d.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 == 1) {
                return c.a.j0.a.b.d.a().h();
            }
            return c.a.j0.a.b.d.a().g();
        }
        return invokeI.intValue;
    }
}
