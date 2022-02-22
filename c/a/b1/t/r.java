package c.a.b1.t;

import android.graphics.PointF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, pointF, pointF2)) == null) {
            if (pointF != null && pointF2 != null) {
                float b2 = ((pointF.x * pointF2.x) + (pointF.y * pointF2.y)) / (b(pointF) * b(pointF2));
                if (b2 <= 1.0f && b2 >= -1.0f) {
                    return ((pointF.x * pointF2.y) - (pointF2.x * pointF.y) > 0.0f ? 1 : -1) * (360.0f - ((float) Math.toDegrees(Math.acos(b2))));
                }
            }
            return 0.0f;
        }
        return invokeLL.floatValue;
    }

    public static float b(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pointF)) == null) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            return (float) Math.sqrt((f2 * f2) + (f3 * f3));
        }
        return invokeL.floatValue;
    }

    public static float c(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pointF, pointF2)) == null) {
            float f2 = pointF.x;
            float f3 = pointF2.x;
            float f4 = pointF.y;
            float f5 = pointF2.y;
            return (float) Math.sqrt(((f2 - f3) * (f2 - f3)) + ((f4 - f5) * (f4 - f5)));
        }
        return invokeLL.floatValue;
    }

    public static PointF d(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, pointF, pointF2)) == null) ? new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y) : (PointF) invokeLL.objValue;
    }

    public static float e(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pointF, pointF2)) == null) {
            if (pointF == null || pointF2 == null) {
                return 1.0f;
            }
            return b(pointF2) / b(pointF);
        }
        return invokeLL.floatValue;
    }
}
