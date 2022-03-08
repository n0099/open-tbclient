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
            b.C0186b c0186b = new b.C0186b(gVar.e(), gVar.f3494g);
            c0186b.t("rsplash");
            c0186b.i(gVar.f3493f == 1);
            c0186b.f(b());
            c0186b.m(c());
            c0186b.o(gVar.f3493f == 1);
            c0186b.n(d(gVar.m));
            c0186b.z(gVar.n * 1000);
            c0186b.x(1);
            c0186b.C(SplashStyleRecorder.a());
            c0186b.g(5);
            c0186b.v(false);
            c0186b.c(gVar.l);
            c0186b.e(25);
            c0186b.d(13);
            c0186b.y(72);
            c0186b.w(30);
            c0186b.B(68);
            c0186b.A(30);
            c0186b.h(17);
            c0186b.q(gVar.y);
            c0186b.u(gVar.z == 1);
            c0186b.b(gVar.A);
            c0186b.p(gVar.d());
            c0186b.r("跳转详情页或第三方应用");
            c0186b.s(gVar.g() ? 47 : b() + 39);
            c0186b.j(gVar.G);
            c0186b.l(gVar.F);
            c0186b.k(gVar.H);
            return c0186b.a();
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
