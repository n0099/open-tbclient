package c.a.e0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.h0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c.a.h0.a.b a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            b.C0067b c0067b = new b.C0067b(hVar.e(), hVar.f3119g);
            c0067b.t("rsplash");
            c0067b.l(hVar.f3118f == 1);
            c0067b.h(b());
            c0067b.m(c());
            c0067b.o(hVar.f3118f == 1);
            c0067b.n(d(hVar.m));
            c0067b.B(hVar.n * 1000);
            c0067b.z(1);
            c0067b.E(SplashStyleRecorder.a());
            c0067b.i(5);
            c0067b.x(false);
            c0067b.c(hVar.l);
            c0067b.e(25);
            c0067b.d(13);
            c0067b.A(72);
            c0067b.y(30);
            c0067b.D(68);
            c0067b.C(30);
            c0067b.k(17);
            c0067b.q(hVar.y);
            c0067b.w(hVar.z == 1);
            c0067b.b(hVar.A);
            c0067b.p(hVar.d());
            c0067b.r("跳转详情页或第三方应用");
            c0067b.s(hVar.f() ? 47 : b() + 39);
            return c0067b.a();
        }
        return (c.a.h0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c.a.e0.a.b.a.f3041a.get() == null || c.a.e0.a.b.a.f3041a.get().d() == 0) {
                return 120;
            }
            return c.a.e0.a.b.a.f3041a.get().d();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c.a.e0.a.b.a.f3041a.get() == null) {
                return -1;
            }
            return c.a.e0.a.b.a.f3041a.get().e();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (c.a.e0.a.b.a.f3041a.get() == null) {
                return -1;
            }
            if (i2 == 1) {
                return c.a.e0.a.b.a.f3041a.get().E();
            }
            return c.a.e0.a.b.a.f3041a.get().B();
        }
        return invokeI.intValue;
    }
}
