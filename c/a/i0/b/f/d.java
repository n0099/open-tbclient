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
            b.C0209b c0209b = new b.C0209b(gVar.e(), gVar.f3927g);
            c0209b.t("rsplash");
            c0209b.i(gVar.f3926f == 1);
            c0209b.f(b());
            c0209b.m(c());
            c0209b.o(gVar.f3926f == 1);
            c0209b.n(d(gVar.m));
            c0209b.z(gVar.n * 1000);
            c0209b.x(1);
            c0209b.C(SplashStyleRecorder.a());
            c0209b.g(5);
            c0209b.v(false);
            c0209b.c(gVar.l);
            c0209b.e(25);
            c0209b.d(13);
            c0209b.y(72);
            c0209b.w(30);
            c0209b.B(68);
            c0209b.A(30);
            c0209b.h(17);
            c0209b.q(gVar.y);
            c0209b.u(gVar.z == 1);
            c0209b.b(gVar.A);
            c0209b.p(gVar.d());
            c0209b.r("跳转详情页或第三方应用");
            c0209b.s(gVar.g() ? 47 : b() + 39);
            c0209b.j(gVar.G);
            c0209b.l(gVar.F);
            c0209b.k(gVar.H);
            return c0209b.a();
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
