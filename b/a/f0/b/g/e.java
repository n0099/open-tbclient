package b.a.f0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import b.a.j0.a.b;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static b.a.j0.a.b a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            b.C0071b c0071b = new b.C0071b(hVar.e(), hVar.f2862g);
            c0071b.w("rsplash");
            c0071b.l(hVar.f2861f == 1);
            c0071b.h(b());
            c0071b.p(c());
            c0071b.r(hVar.f2861f == 1);
            c0071b.q(d(hVar.m));
            c0071b.E(hVar.n * 1000);
            c0071b.C(1);
            c0071b.H(SplashStyleRecorder.a());
            c0071b.i(5);
            c0071b.A(false);
            c0071b.c(hVar.l);
            c0071b.e(25);
            c0071b.d(13);
            c0071b.D(72);
            c0071b.B(30);
            c0071b.G(68);
            c0071b.F(30);
            c0071b.k(17);
            c0071b.t(hVar.y);
            c0071b.z(hVar.z == 1);
            c0071b.b(hVar.A);
            c0071b.s(hVar.d());
            c0071b.u("跳转详情页或第三方应用");
            c0071b.v(hVar.g() ? 47 : b() + 39);
            c0071b.m(hVar.G);
            c0071b.o(hVar.F);
            c0071b.n(hVar.H);
            return c0071b.a();
        }
        return (b.a.j0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b.a.f0.a.b.a.f2781a.get() == null || b.a.f0.a.b.a.f2781a.get().d() == 0) {
                return 120;
            }
            return b.a.f0.a.b.a.f2781a.get().d();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b.a.f0.a.b.a.f2781a.get() == null) {
                return -1;
            }
            return b.a.f0.a.b.a.f2781a.get().e();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (b.a.f0.a.b.a.f2781a.get() == null) {
                return -1;
            }
            if (i2 == 1) {
                return b.a.f0.a.b.a.f2781a.get().D();
            }
            return b.a.f0.a.b.a.f2781a.get().A();
        }
        return invokeI.intValue;
    }
}
