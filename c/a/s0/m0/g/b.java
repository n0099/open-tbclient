package c.a.s0.m0.g;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2027764255, "Lc/a/s0/m0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2027764255, "Lc/a/s0/m0/g/b;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final boolean a(c.a.s0.m0.e.a aVar, c.a.s0.m0.e.a aVar2, c.a.s0.m0.j.b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{aVar, aVar2, bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int width = bVar.getWidth();
            float q = aVar.f().q();
            float q2 = aVar2.f().q();
            long j4 = j2 - aVar.j();
            float f2 = width;
            float f3 = (float) j3;
            return f2 - ((q2 + f2) * (((float) (j2 - aVar2.j())) / f3)) < (f2 - ((f2 + q) * (((float) j4) / f3))) + q;
        }
        return invokeCommon.booleanValue;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Bitmap) invokeV.objValue;
    }

    public static final boolean c(c.a.s0.m0.e.a aVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, aVar, j2)) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            return j2 - aVar.j() < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(c.a.s0.m0.e.a aVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, j2)) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            return e(aVar, j2) || c(aVar, j2);
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(c.a.s0.m0.e.a aVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, aVar, j2)) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            return j2 - aVar.j() > aVar.g();
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(c.a.s0.m0.e.a aVar, c.a.s0.m0.e.a danmaku, c.a.s0.m0.j.b displayer, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{aVar, danmaku, displayer, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(aVar, j2)) {
                return false;
            }
            long j4 = danmaku.j() - aVar.j();
            if (j4 <= 0) {
                return true;
            }
            if (Math.abs(j4) >= j3 || e(aVar, j2) || e(danmaku, j2)) {
                return false;
            }
            return aVar.e().j() == 5 || aVar.e().j() == 4 || a(aVar, danmaku, displayer, j2, j3) || a(aVar, danmaku, displayer, j2 + j3, j3);
        }
        return invokeCommon.booleanValue;
    }
}
