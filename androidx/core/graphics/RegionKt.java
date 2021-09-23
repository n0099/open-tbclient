package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\n\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u0003\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u0011\u001a\u00020\u000f*\u00020\u00002!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0004\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0005\u001a\u0014\u0010\u0017\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¢\u0006\u0004\b\u0019\u0010\u0004\u001a\u001c\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u001c\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u001a\u0010\u0004\u001a\u001c\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u001a\u0010\u0005\u001a\u0014\u0010\u001b\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u001b\u0010\u0018\u001a\u001c\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¢\u0006\u0004\b\u001c\u0010\u0004\u001a\u001c\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u001c\u0010\u0005¨\u0006\u001d"}, d2 = {"Landroid/graphics/Region;", "Landroid/graphics/Rect;", r.f42342a, "and", "(Landroid/graphics/Region;Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/Region;Landroid/graphics/Region;)Landroid/graphics/Region;", "Landroid/graphics/Point;", "p", "", "contains", "(Landroid/graphics/Region;Landroid/graphics/Point;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "", "action", "forEach", "(Landroid/graphics/Region;Lkotlin/Function1;)V", "", "iterator", "(Landroid/graphics/Region;)Ljava/util/Iterator;", "minus", "not", "(Landroid/graphics/Region;)Landroid/graphics/Region;", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class RegionKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Region and(Region region, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, region, rect)) == null) {
            Region region2 = new Region(region);
            region2.op(rect, Region.Op.INTERSECT);
            return region2;
        }
        return (Region) invokeLL.objValue;
    }

    public static final boolean contains(Region region, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, region, point)) == null) ? region.contains(point.x, point.y) : invokeLL.booleanValue;
    }

    public static final void forEach(Region region, Function1<? super Rect, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, region, function1) != null) {
            return;
        }
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            }
            function1.invoke(rect);
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, region)) == null) ? new RegionKt$iterator$1(region) : (Iterator) invokeL.objValue;
    }

    public static final Region minus(Region region, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, region, rect)) == null) {
            Region region2 = new Region(region);
            region2.op(rect, Region.Op.DIFFERENCE);
            return region2;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region not(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, region)) == null) {
            Region region2 = new Region(region.getBounds());
            region2.op(region, Region.Op.DIFFERENCE);
            return region2;
        }
        return (Region) invokeL.objValue;
    }

    public static final Region or(Region region, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, region, rect)) == null) {
            Region region2 = new Region(region);
            region2.union(rect);
            return region2;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region plus(Region region, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, region, rect)) == null) {
            Region region2 = new Region(region);
            region2.union(rect);
            return region2;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region unaryMinus(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, region)) == null) {
            Region region2 = new Region(region.getBounds());
            region2.op(region, Region.Op.DIFFERENCE);
            return region2;
        }
        return (Region) invokeL.objValue;
    }

    public static final Region xor(Region region, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, region, rect)) == null) {
            Region region2 = new Region(region);
            region2.op(rect, Region.Op.XOR);
            return region2;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region and(Region region, Region region2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, region, region2)) == null) {
            Region region3 = new Region(region);
            region3.op(region2, Region.Op.INTERSECT);
            return region3;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region minus(Region region, Region region2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, region, region2)) == null) {
            Region region3 = new Region(region);
            region3.op(region2, Region.Op.DIFFERENCE);
            return region3;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region or(Region region, Region region2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, region, region2)) == null) {
            Region region3 = new Region(region);
            region3.op(region2, Region.Op.UNION);
            return region3;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region plus(Region region, Region region2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, region, region2)) == null) {
            Region region3 = new Region(region);
            region3.op(region2, Region.Op.UNION);
            return region3;
        }
        return (Region) invokeLL.objValue;
    }

    public static final Region xor(Region region, Region region2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, region, region2)) == null) {
            Region region3 = new Region(region);
            region3.op(region2, Region.Op.XOR);
            return region3;
        }
        return (Region) invokeLL.objValue;
    }
}
