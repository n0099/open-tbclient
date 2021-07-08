package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\u0007\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0007\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000b\u0010\b\u001a\u0014\u0010\u000b\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u000b\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\f\u0010\b\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\f\u0010\n\u001a\u0014\u0010\r\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\r\u0010\b\u001a\u0014\u0010\r\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\r\u0010\n\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u0011\u0010\u0014\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0016\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0019\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u0016\u0010\u001a\u001a\u001c\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u0016\u0010\u001b\u001a\u001c\u0010\u0016\u001a\u00020\u0018*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0016\u0010\u001c\u001a\u001c\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u0016\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u001e\u0010\u0003\u001a\u001c\u0010\u001e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u001f\u0010\u0017\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u001f\u0010\u0003\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u001f\u0010\u001a\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u001f\u0010\u001b\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\u001f\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u001f\u0010\u001d\u001a\u001c\u0010!\u001a\u00020\u0000*\u00020\u00002\u0006\u0010 \u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b!\u0010\u001a\u001a\u001c\u0010!\u001a\u00020\u0004*\u00020\u00042\u0006\u0010 \u001a\u00020\tH\u0086\n¢\u0006\u0004\b!\u0010\u001d\u001a\u001c\u0010!\u001a\u00020\u0004*\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010#\u001a\u00020\u0000*\u00020\u0004H\u0086\b¢\u0006\u0004\b#\u0010$\u001a\u0014\u0010%\u001a\u00020\u0004*\u00020\u0000H\u0086\b¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010'\u001a\u00020\u0018*\u00020\u0000H\u0086\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010'\u001a\u00020\u0018*\u00020\u0004H\u0086\b¢\u0006\u0004\b'\u0010)\u001a\u001c\u0010,\u001a\u00020\u0004*\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0086\b¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010.\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b.\u0010\u0019\u001a\u001c\u0010.\u001a\u00020\u0018*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b.\u0010\u001c¨\u0006/"}, d2 = {"Landroid/graphics/Rect;", r.f7762a, "and", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/RectF;", "", "component1", "(Landroid/graphics/Rect;)I", "", "(Landroid/graphics/RectF;)F", "component2", "component3", "component4", "Landroid/graphics/Point;", "p", "", "contains", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Z", "Landroid/graphics/PointF;", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Z", "xy", "minus", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Landroid/graphics/Rect;", "Landroid/graphics/Region;", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/Rect;I)Landroid/graphics/Rect;", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Landroid/graphics/RectF;", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/Region;", "(Landroid/graphics/RectF;F)Landroid/graphics/RectF;", "or", "plus", "factor", "times", "(Landroid/graphics/RectF;I)Landroid/graphics/RectF;", "toRect", "(Landroid/graphics/RectF;)Landroid/graphics/Rect;", "toRectF", "(Landroid/graphics/Rect;)Landroid/graphics/RectF;", "toRegion", "(Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/RectF;)Landroid/graphics/Region;", "Landroid/graphics/Matrix;", "m", "transform", "(Landroid/graphics/RectF;Landroid/graphics/Matrix;)Landroid/graphics/RectF;", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class RectKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, rect, rect2)) == null) {
            Rect rect3 = new Rect(rect);
            rect3.intersect(rect2);
            return rect3;
        }
        return (Rect) invokeLL.objValue;
    }

    public static final int component1(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rect)) == null) ? rect.left : invokeL.intValue;
    }

    public static final int component2(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, rect)) == null) ? rect.top : invokeL.intValue;
    }

    public static final int component3(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, rect)) == null) ? rect.right : invokeL.intValue;
    }

    public static final int component4(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, rect)) == null) ? rect.bottom : invokeL.intValue;
    }

    public static final boolean contains(Rect rect, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, rect, point)) == null) ? rect.contains(point.x, point.y) : invokeLL.booleanValue;
    }

    public static final Region minus(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, rect, rect2)) == null) {
            Region region = new Region(rect);
            region.op(rect2, Region.Op.DIFFERENCE);
            return region;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Rect or(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, rect, rect2)) == null) {
            Rect rect3 = new Rect(rect);
            rect3.union(rect2);
            return rect3;
        }
        return (Rect) invokeLL.objValue;
    }

    public static final Rect plus(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, rect, rect2)) == null) {
            Rect rect3 = new Rect(rect);
            rect3.union(rect2);
            return rect3;
        }
        return (Rect) invokeLL.objValue;
    }

    public static final Rect times(Rect rect, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65562, null, rect, i2)) == null) {
            Rect rect2 = new Rect(rect);
            rect2.top *= i2;
            rect2.left *= i2;
            rect2.right *= i2;
            rect2.bottom *= i2;
            return rect2;
        }
        return (Rect) invokeLI.objValue;
    }

    public static final Rect toRect(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, rectF)) == null) {
            Rect rect = new Rect();
            rectF.roundOut(rect);
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static final RectF toRectF(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, rect)) == null) ? new RectF(rect) : (RectF) invokeL.objValue;
    }

    public static final Region toRegion(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, rect)) == null) ? new Region(rect) : (Region) invokeL.objValue;
    }

    public static final RectF transform(RectF rectF, Matrix matrix) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, rectF, matrix)) == null) {
            matrix.mapRect(rectF);
            return rectF;
        }
        return (RectF) invokeLL.objValue;
    }

    public static final Region xor(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, rect, rect2)) == null) {
            Region region = new Region(rect);
            region.op(rect2, Region.Op.XOR);
            return region;
        }
        return (Region) invokeLL.objValue;
    }

    public static final float component1(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rectF)) == null) ? rectF.left : invokeL.floatValue;
    }

    public static final float component2(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rectF)) == null) ? rectF.top : invokeL.floatValue;
    }

    public static final float component3(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, rectF)) == null) ? rectF.right : invokeL.floatValue;
    }

    public static final float component4(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, rectF)) == null) ? rectF.bottom : invokeL.floatValue;
    }

    public static final boolean contains(RectF rectF, PointF pointF) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, rectF, pointF)) == null) ? rectF.contains(pointF.x, pointF.y) : invokeLL.booleanValue;
    }

    public static final Region toRegion(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, rectF)) == null) {
            Rect rect = new Rect();
            rectF.roundOut(rect);
            return new Region(rect);
        }
        return (Region) invokeL.objValue;
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF rectF, RectF rectF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, rectF, rectF2)) == null) {
            RectF rectF3 = new RectF(rectF);
            rectF3.intersect(rectF2);
            return rectF3;
        }
        return (RectF) invokeLL.objValue;
    }

    public static final Rect minus(Rect rect, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, rect, i2)) == null) {
            Rect rect2 = new Rect(rect);
            int i3 = -i2;
            rect2.offset(i3, i3);
            return rect2;
        }
        return (Rect) invokeLI.objValue;
    }

    public static final RectF or(RectF rectF, RectF rectF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, rectF, rectF2)) == null) {
            RectF rectF3 = new RectF(rectF);
            rectF3.union(rectF2);
            return rectF3;
        }
        return (RectF) invokeLL.objValue;
    }

    public static final RectF plus(RectF rectF, RectF rectF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, rectF, rectF2)) == null) {
            RectF rectF3 = new RectF(rectF);
            rectF3.union(rectF2);
            return rectF3;
        }
        return (RectF) invokeLL.objValue;
    }

    public static final Region xor(RectF rectF, RectF rectF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, rectF, rectF2)) == null) {
            Rect rect = new Rect();
            rectF.roundOut(rect);
            Region region = new Region(rect);
            Rect rect2 = new Rect();
            rectF2.roundOut(rect2);
            region.op(rect2, Region.Op.XOR);
            return region;
        }
        return (Region) invokeLL.objValue;
    }

    public static final RectF minus(RectF rectF, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65550, null, rectF, f2)) == null) {
            RectF rectF2 = new RectF(rectF);
            float f3 = -f2;
            rectF2.offset(f3, f3);
            return rectF2;
        }
        return (RectF) invokeLF.objValue;
    }

    public static final Rect plus(Rect rect, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, rect, i2)) == null) {
            Rect rect2 = new Rect(rect);
            rect2.offset(i2, i2);
            return rect2;
        }
        return (Rect) invokeLI.objValue;
    }

    public static final RectF times(RectF rectF, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65563, null, rectF, f2)) == null) {
            RectF rectF2 = new RectF(rectF);
            rectF2.top *= f2;
            rectF2.left *= f2;
            rectF2.right *= f2;
            rectF2.bottom *= f2;
            return rectF2;
        }
        return (RectF) invokeLF.objValue;
    }

    public static final Rect minus(Rect rect, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, rect, point)) == null) {
            Rect rect2 = new Rect(rect);
            rect2.offset(-point.x, -point.y);
            return rect2;
        }
        return (Rect) invokeLL.objValue;
    }

    public static final RectF plus(RectF rectF, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65559, null, rectF, f2)) == null) {
            RectF rectF2 = new RectF(rectF);
            rectF2.offset(f2, f2);
            return rectF2;
        }
        return (RectF) invokeLF.objValue;
    }

    public static final RectF minus(RectF rectF, PointF pointF) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, rectF, pointF)) == null) {
            RectF rectF2 = new RectF(rectF);
            rectF2.offset(-pointF.x, -pointF.y);
            return rectF2;
        }
        return (RectF) invokeLL.objValue;
    }

    public static final Rect plus(Rect rect, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, rect, point)) == null) {
            Rect rect2 = new Rect(rect);
            rect2.offset(point.x, point.y);
            return rect2;
        }
        return (Rect) invokeLL.objValue;
    }

    public static final Region minus(RectF rectF, RectF rectF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, rectF, rectF2)) == null) {
            Rect rect = new Rect();
            rectF.roundOut(rect);
            Region region = new Region(rect);
            Rect rect2 = new Rect();
            rectF2.roundOut(rect2);
            region.op(rect2, Region.Op.DIFFERENCE);
            return region;
        }
        return (Region) invokeLL.objValue;
    }

    public static final RectF plus(RectF rectF, PointF pointF) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, rectF, pointF)) == null) {
            RectF rectF2 = new RectF(rectF);
            rectF2.offset(pointF.x, pointF.y);
            return rectF2;
        }
        return (RectF) invokeLL.objValue;
    }

    public static final RectF times(RectF rectF, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, rectF, i2)) == null) {
            float f2 = i2;
            RectF rectF2 = new RectF(rectF);
            rectF2.top *= f2;
            rectF2.left *= f2;
            rectF2.right *= f2;
            rectF2.bottom *= f2;
            return rectF2;
        }
        return (RectF) invokeLI.objValue;
    }
}
