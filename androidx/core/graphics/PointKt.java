package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\t\u0010\f\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\t\u0010\r\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\n¢\u0006\u0004\b\t\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000f\u0010\n\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u000f\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\u000f\u0010\r\u001a\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\n¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0014\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroid/graphics/Point;", "", "component1", "(Landroid/graphics/Point;)I", "Landroid/graphics/PointF;", "", "(Landroid/graphics/PointF;)F", "component2", "p", "minus", "(Landroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Point;", "xy", "(Landroid/graphics/Point;I)Landroid/graphics/Point;", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)Landroid/graphics/PointF;", "(Landroid/graphics/PointF;F)Landroid/graphics/PointF;", "plus", "toPoint", "(Landroid/graphics/PointF;)Landroid/graphics/Point;", "toPointF", "(Landroid/graphics/Point;)Landroid/graphics/PointF;", "unaryMinus", "(Landroid/graphics/Point;)Landroid/graphics/Point;", "(Landroid/graphics/PointF;)Landroid/graphics/PointF;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class PointKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int component1(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, point)) == null) ? point.x : invokeL.intValue;
    }

    public static final int component2(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, point)) == null) ? point.y : invokeL.intValue;
    }

    public static final Point minus(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, point, point2)) == null) {
            Point point3 = new Point(point.x, point.y);
            point3.offset(-point2.x, -point2.y);
            return point3;
        }
        return (Point) invokeLL.objValue;
    }

    public static final Point plus(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, point, point2)) == null) {
            Point point3 = new Point(point.x, point.y);
            point3.offset(point2.x, point2.y);
            return point3;
        }
        return (Point) invokeLL.objValue;
    }

    public static final Point toPoint(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, pointF)) == null) ? new Point((int) pointF.x, (int) pointF.y) : (Point) invokeL.objValue;
    }

    public static final PointF toPointF(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, point)) == null) ? new PointF(point) : (PointF) invokeL.objValue;
    }

    public static final Point unaryMinus(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, point)) == null) ? new Point(-point.x, -point.y) : (Point) invokeL.objValue;
    }

    public static final float component1(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pointF)) == null) ? pointF.x : invokeL.floatValue;
    }

    public static final float component2(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pointF)) == null) ? pointF.y : invokeL.floatValue;
    }

    public static final PointF unaryMinus(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, pointF)) == null) ? new PointF(-pointF.x, -pointF.y) : (PointF) invokeL.objValue;
    }

    public static final PointF minus(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, pointF, pointF2)) == null) {
            PointF pointF3 = new PointF(pointF.x, pointF.y);
            pointF3.offset(-pointF2.x, -pointF2.y);
            return pointF3;
        }
        return (PointF) invokeLL.objValue;
    }

    public static final PointF plus(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, pointF, pointF2)) == null) {
            PointF pointF3 = new PointF(pointF.x, pointF.y);
            pointF3.offset(pointF2.x, pointF2.y);
            return pointF3;
        }
        return (PointF) invokeLL.objValue;
    }

    public static final Point minus(Point point, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, point, i2)) == null) {
            Point point2 = new Point(point.x, point.y);
            int i3 = -i2;
            point2.offset(i3, i3);
            return point2;
        }
        return (Point) invokeLI.objValue;
    }

    public static final Point plus(Point point, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, point, i2)) == null) {
            Point point2 = new Point(point.x, point.y);
            point2.offset(i2, i2);
            return point2;
        }
        return (Point) invokeLI.objValue;
    }

    public static final PointF minus(PointF pointF, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.BAIDU_LOGO_ID, null, pointF, f2)) == null) {
            PointF pointF2 = new PointF(pointF.x, pointF.y);
            float f3 = -f2;
            pointF2.offset(f3, f3);
            return pointF2;
        }
        return (PointF) invokeLF.objValue;
    }

    public static final PointF plus(PointF pointF, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65546, null, pointF, f2)) == null) {
            PointF pointF2 = new PointF(pointF.x, pointF.y);
            pointF2.offset(f2, f2);
            return pointF2;
        }
        return (PointF) invokeLF.objValue;
    }
}
