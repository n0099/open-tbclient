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
            b.C0200b c0200b = new b.C0200b(gVar.e(), gVar.f3786g);
            c0200b.t("rsplash");
            c0200b.i(gVar.f3785f == 1);
            c0200b.f(b());
            c0200b.m(c());
            c0200b.o(gVar.f3785f == 1);
            c0200b.n(d(gVar.m));
            c0200b.z(gVar.n * 1000);
            c0200b.x(1);
            c0200b.C(SplashStyleRecorder.a());
            c0200b.g(5);
            c0200b.v(false);
            c0200b.c(gVar.l);
            c0200b.e(25);
            c0200b.d(13);
            c0200b.y(72);
            c0200b.w(30);
            c0200b.B(68);
            c0200b.A(30);
            c0200b.h(17);
            c0200b.q(gVar.y);
            c0200b.u(gVar.z == 1);
            c0200b.b(gVar.A);
            c0200b.p(gVar.d());
            c0200b.r("跳转详情页或第三方应用");
            c0200b.s(gVar.g() ? 47 : b() + 39);
            c0200b.j(gVar.G);
            c0200b.l(gVar.F);
            c0200b.k(gVar.H);
            return c0200b.a();
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
