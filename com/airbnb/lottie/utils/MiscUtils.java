package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class MiscUtils {
    public static /* synthetic */ Interceptable $ic;
    public static PointF pathFromDataCurrentPoint;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2083572987, "Lcom/airbnb/lottie/utils/MiscUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2083572987, "Lcom/airbnb/lottie/utils/MiscUtils;");
                return;
            }
        }
        pathFromDataCurrentPoint = new PointF();
    }

    public MiscUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pointF, pointF2)) == null) ? new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y) : (PointF) invokeLL.objValue;
    }

    public static int clamp(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) ? Math.max(i3, Math.min(i4, i2)) : invokeIII.intValue;
    }

    public static boolean contains(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 >= f3 && f2 <= f4 : invokeCommon.booleanValue;
    }

    public static int floorDiv(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) {
            int i4 = i2 / i3;
            return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
        }
        return invokeII.intValue;
    }

    public static int floorMod(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? floorMod((int) f2, (int) f3) : invokeCommon.intValue;
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, shapeData, path) == null) {
            path.reset();
            PointF initialPoint = shapeData.getInitialPoint();
            path.moveTo(initialPoint.x, initialPoint.y);
            pathFromDataCurrentPoint.set(initialPoint.x, initialPoint.y);
            for (int i2 = 0; i2 < shapeData.getCurves().size(); i2++) {
                CubicCurveData cubicCurveData = shapeData.getCurves().get(i2);
                PointF controlPoint1 = cubicCurveData.getControlPoint1();
                PointF controlPoint2 = cubicCurveData.getControlPoint2();
                PointF vertex = cubicCurveData.getVertex();
                if (controlPoint1.equals(pathFromDataCurrentPoint) && controlPoint2.equals(vertex)) {
                    path.lineTo(vertex.x, vertex.y);
                } else {
                    path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
                }
                pathFromDataCurrentPoint.set(vertex.x, vertex.y);
            }
            if (shapeData.isClosed()) {
                path.close();
            }
        }
    }

    public static double lerp(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? d2 + (d4 * (d3 - d2)) : invokeCommon.doubleValue;
    }

    public static float lerp(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 + (f4 * (f3 - f2)) : invokeCommon.floatValue;
    }

    public static int lerp(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) ? (int) (i2 + (f2 * (i3 - i2))) : invokeCommon.intValue;
    }

    public static void resolveKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{keyPath, Integer.valueOf(i2), list, keyPath2, keyPathElementContent}) == null) && keyPath.fullyResolvesTo(keyPathElementContent.getName(), i2)) {
            list.add(keyPath2.addKey(keyPathElementContent.getName()).resolve(keyPathElementContent));
        }
    }

    public static float clamp(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.max(f3, Math.min(f4, f2)) : invokeCommon.floatValue;
    }

    public static int floorMod(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65545, null, i2, i3)) == null) ? i2 - (i3 * floorDiv(i2, i3)) : invokeII.intValue;
    }

    public static double clamp(double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? Math.max(d3, Math.min(d4, d2)) : invokeCommon.doubleValue;
    }
}
