package c.a.g0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.k0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c.a.k0.a.b a(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            b.C0132b c0132b = new b.C0132b(gVar.e(), gVar.f3343g);
            c0132b.t("rsplash");
            c0132b.i(gVar.f3342f == 1);
            c0132b.f(b());
            c0132b.m(c());
            c0132b.o(gVar.f3342f == 1);
            c0132b.n(d(gVar.m));
            c0132b.z(gVar.n * 1000);
            c0132b.x(1);
            c0132b.C(SplashStyleRecorder.a());
            c0132b.g(5);
            c0132b.v(false);
            c0132b.c(gVar.l);
            c0132b.e(25);
            c0132b.d(13);
            c0132b.y(72);
            c0132b.w(30);
            c0132b.B(68);
            c0132b.A(30);
            c0132b.h(17);
            c0132b.q(gVar.y);
            c0132b.u(gVar.z == 1);
            c0132b.b(gVar.A);
            c0132b.p(gVar.d());
            c0132b.r("跳转详情页或第三方应用");
            c0132b.s(gVar.g() ? 47 : b() + 39);
            c0132b.j(gVar.G);
            c0132b.l(gVar.F);
            c0132b.k(gVar.H);
            return c0132b.a();
        }
        return (c.a.k0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.g0.a.b.d.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.g0.a.b.d.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 == 1) {
                return c.a.g0.a.b.d.a().h();
            }
            return c.a.g0.a.b.d.a().g();
        }
        return invokeI.intValue;
    }
}
