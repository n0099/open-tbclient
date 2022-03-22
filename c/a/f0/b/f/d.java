package c.a.f0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.i0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c.a.i0.a.b a(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            b.C0144b c0144b = new b.C0144b(gVar.e(), gVar.f2935g);
            c0144b.t("rsplash");
            c0144b.i(gVar.f2934f == 1);
            c0144b.f(b());
            c0144b.m(c());
            c0144b.o(gVar.f2934f == 1);
            c0144b.n(d(gVar.m));
            c0144b.z(gVar.n * 1000);
            c0144b.x(1);
            c0144b.C(SplashStyleRecorder.a());
            c0144b.g(5);
            c0144b.v(false);
            c0144b.c(gVar.l);
            c0144b.e(25);
            c0144b.d(13);
            c0144b.y(72);
            c0144b.w(30);
            c0144b.B(68);
            c0144b.A(30);
            c0144b.h(17);
            c0144b.q(gVar.y);
            c0144b.u(gVar.z == 1);
            c0144b.b(gVar.A);
            c0144b.p(gVar.d());
            c0144b.r("跳转详情页或第三方应用");
            c0144b.s(gVar.g() ? 47 : b() + 39);
            c0144b.j(gVar.G);
            c0144b.l(gVar.F);
            c0144b.k(gVar.H);
            return c0144b.a();
        }
        return (c.a.i0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.f0.a.b.d.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.f0.a.b.d.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return c.a.f0.a.b.d.a().h();
            }
            return c.a.f0.a.b.d.a().g();
        }
        return invokeI.intValue;
    }
}
