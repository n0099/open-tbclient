package c.a.h0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.l0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c.a.l0.a.b a(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            b.C0166b c0166b = new b.C0166b(gVar.e(), gVar.f3391g);
            c0166b.t("rsplash");
            c0166b.i(gVar.f3390f == 1);
            c0166b.f(b());
            c0166b.m(c());
            c0166b.o(gVar.f3390f == 1);
            c0166b.n(d(gVar.m));
            c0166b.z(gVar.n * 1000);
            c0166b.x(1);
            c0166b.C(SplashStyleRecorder.a());
            c0166b.g(5);
            c0166b.v(false);
            c0166b.c(gVar.l);
            c0166b.e(25);
            c0166b.d(13);
            c0166b.y(72);
            c0166b.w(30);
            c0166b.B(68);
            c0166b.A(30);
            c0166b.h(17);
            c0166b.q(gVar.y);
            c0166b.u(gVar.z == 1);
            c0166b.b(gVar.A);
            c0166b.p(gVar.d());
            c0166b.r("跳转详情页或第三方应用");
            c0166b.s(gVar.g() ? 47 : b() + 39);
            c0166b.j(gVar.G);
            c0166b.l(gVar.F);
            c0166b.k(gVar.H);
            return c0166b.a();
        }
        return (c.a.l0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.h0.a.b.d.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.h0.a.b.d.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 == 1) {
                return c.a.h0.a.b.d.a().h();
            }
            return c.a.h0.a.b.d.a().g();
        }
        return invokeI.intValue;
    }
}
