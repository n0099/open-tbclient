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
            b.C0073b c0073b = new b.C0073b(hVar.e(), hVar.f2955g);
            c0073b.w("rsplash");
            c0073b.l(hVar.f2954f == 1);
            c0073b.h(b());
            c0073b.p(c());
            c0073b.r(hVar.f2954f == 1);
            c0073b.q(d(hVar.m));
            c0073b.E(hVar.n * 1000);
            c0073b.C(1);
            c0073b.H(SplashStyleRecorder.a());
            c0073b.i(5);
            c0073b.A(false);
            c0073b.c(hVar.l);
            c0073b.e(25);
            c0073b.d(13);
            c0073b.D(72);
            c0073b.B(30);
            c0073b.G(68);
            c0073b.F(30);
            c0073b.k(17);
            c0073b.t(hVar.y);
            c0073b.z(hVar.z == 1);
            c0073b.b(hVar.A);
            c0073b.s(hVar.d());
            c0073b.u("跳转详情页或第三方应用");
            c0073b.v(hVar.g() ? 47 : b() + 39);
            c0073b.m(hVar.G);
            c0073b.o(hVar.F);
            c0073b.n(hVar.H);
            return c0073b.a();
        }
        return (b.a.j0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b.a.f0.a.b.a.f2874a.get() == null || b.a.f0.a.b.a.f2874a.get().d() == 0) {
                return 120;
            }
            return b.a.f0.a.b.a.f2874a.get().d();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b.a.f0.a.b.a.f2874a.get() == null) {
                return -1;
            }
            return b.a.f0.a.b.a.f2874a.get().e();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (b.a.f0.a.b.a.f2874a.get() == null) {
                return -1;
            }
            if (i2 == 1) {
                return b.a.f0.a.b.a.f2874a.get().D();
            }
            return b.a.f0.a.b.a.f2874a.get().A();
        }
        return invokeI.intValue;
    }
}
