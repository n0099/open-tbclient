package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a>\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u0006\u0010\f\u001a-\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0016\u001a\u00020\b*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0016\u001a\u00020\b*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0018H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0019\u001a$\u0010\u001c\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a.\u0010\u001f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u001f\u0010 \u001a.\u0010\"\u001a\u00020\u000f*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00002\b\b\u0001\u0010!\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"", "width", "height", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "createBitmap", "(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "", "hasAlpha", "Landroid/graphics/ColorSpace;", "colorSpace", "(IILandroid/graphics/Bitmap$Config;ZLandroid/graphics/ColorSpace;)Landroid/graphics/Bitmap;", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "applyCanvas", "(Landroid/graphics/Bitmap;Lkotlin/Function1;)Landroid/graphics/Bitmap;", "Landroid/graphics/Point;", "p", "contains", "(Landroid/graphics/Bitmap;Landroid/graphics/Point;)Z", "Landroid/graphics/PointF;", "(Landroid/graphics/Bitmap;Landroid/graphics/PointF;)Z", "x", "y", "get", "(Landroid/graphics/Bitmap;II)I", CloudControlRequest.REQUEST_KEY_FILTER, "scale", "(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;", "color", "set", "(Landroid/graphics/Bitmap;III)V", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class BitmapKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Bitmap applyCanvas(Bitmap bitmap, Function1<? super Canvas, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bitmap, function1)) == null) {
            function1.invoke(new Canvas(bitmap));
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bitmap, point)) == null) {
            int i3 = point.x;
            return i3 >= 0 && i3 < bitmap.getWidth() && (i2 = point.y) >= 0 && i2 < bitmap.getHeight();
        }
        return invokeLL.booleanValue;
    }

    public static final Bitmap createBitmap(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, config)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
            return createBitmap;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bitmap, i2, i3)) == null) ? bitmap.getPixel(i2, i3) : invokeLII.intValue;
    }

    public static final Bitmap scale(Bitmap bitmap, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
            Intrinsics.checkExpressionValueIsNotNull(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
            return createScaledBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = true;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        Intrinsics.checkExpressionValueIsNotNull(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(Bitmap bitmap, int i2, int i3, @ColorInt int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65546, null, bitmap, i2, i3, i4) == null) {
            bitmap.setPixel(i2, i3, i4);
        }
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bitmap, pointF)) == null) {
            float f2 = pointF.x;
            float f3 = 0;
            if (f2 < f3 || f2 >= bitmap.getWidth()) {
                return false;
            }
            float f4 = pointF.y;
            return f4 >= f3 && f4 < ((float) bitmap.getHeight());
        }
        return invokeLL.booleanValue;
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), config, Boolean.valueOf(z), colorSpace})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            Intrinsics.checkExpressionValueIsNotNull(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
