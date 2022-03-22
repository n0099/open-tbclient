package c.a.p0.n0.g;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550720059, "Lc/a/p0/n0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-550720059, "Lc/a/p0/n0/g/b;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final boolean a(c.a.p0.n0.e.a aVar, c.a.p0.n0.e.a aVar2, c.a.p0.n0.j.b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{aVar, aVar2, bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = bVar.getWidth();
            float q = aVar.f().q();
            float q2 = aVar2.f().q();
            long j3 = j - aVar.j();
            float f2 = width;
            float f3 = (float) j2;
            return f2 - ((q2 + f2) * (((float) (j - aVar2.j())) / f3)) < (f2 - ((f2 + q) * (((float) j3) / f3))) + q;
        }
        return invokeCommon.booleanValue;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Bitmap) invokeV.objValue;
    }

    public static final boolean c(c.a.p0.n0.e.a aVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, aVar, j)) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            return j - aVar.j() < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(c.a.p0.n0.e.a aVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, j)) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            return e(aVar, j) || c(aVar, j);
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(c.a.p0.n0.e.a aVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, aVar, j)) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            return j - aVar.j() > aVar.g();
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(c.a.p0.n0.e.a aVar, c.a.p0.n0.e.a danmaku, c.a.p0.n0.j.b displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{aVar, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(aVar, j)) {
                return false;
            }
            long j3 = danmaku.j() - aVar.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(aVar, j) || e(danmaku, j)) {
                return false;
            }
            return aVar.e().j() == 5 || aVar.e().j() == 4 || a(aVar, danmaku, displayer, j, j2) || a(aVar, danmaku, displayer, j + j2, j2);
        }
        return invokeCommon.booleanValue;
    }
}
