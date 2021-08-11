package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\b\u0010\u0005\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\b\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\t\u0010\u0005\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\t\u0010\u0007\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u0003\u001a\u0014\u0010\n\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\n\u0010\u0005\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\n\u0010\u0007\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0087\f¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000fH\u0087\f¢\u0006\u0004\b\r\u0010\u0010\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0087\f¢\u0006\u0004\b\r\u0010\u0011\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000fH\u0087\f¢\u0006\u0004\b\r\u0010\u0012\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0087\f¢\u0006\u0004\b\r\u0010\u0013\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u000fH\u0087\f¢\u0006\u0004\b\r\u0010\u0014\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0018\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u001dH\u0087\b¢\u0006\u0004\b\u001b\u0010\u001e\u001a\u0014\u0010\u001f\u001a\u00020\u0006*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001f\u0010 \"\u0018\u0010\"\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0005\"\u0018\u0010\"\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0007\"\u0018\u0010$\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0005\"\u0018\u0010$\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0007\"\u0018\u0010\f\u001a\u00020\u000b*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0018\u0010(\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010\u0005\"\u0018\u0010(\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010\u0007\"\u0018\u0010*\u001a\u00020)*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010,\u001a\u00020)*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010+\"\u0018\u0010/\u001a\u00020\u0001*\u00020\u00048Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0018\u0010/\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010\u0007\"\u0018\u00101\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010\u0005\"\u0018\u00101\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010\u0007¨\u00062"}, d2 = {"Landroid/graphics/Color;", "", "component1", "(Landroid/graphics/Color;)F", "", "(I)I", "", "(J)F", "component2", "component3", "component4", "Landroid/graphics/ColorSpace;", "colorSpace", "convertTo", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace;)Landroid/graphics/Color;", "Landroid/graphics/ColorSpace$Named;", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace$Named;)Landroid/graphics/Color;", "(ILandroid/graphics/ColorSpace;)J", "(ILandroid/graphics/ColorSpace$Named;)J", "(JLandroid/graphics/ColorSpace;)J", "(JLandroid/graphics/ColorSpace$Named;)J", "c", "plus", "(Landroid/graphics/Color;Landroid/graphics/Color;)Landroid/graphics/Color;", "toColor", "(I)Landroid/graphics/Color;", "(J)Landroid/graphics/Color;", "toColorInt", "(J)I", "", "(Ljava/lang/String;)I", "toColorLong", "(I)J", "getAlpha", "alpha", "getBlue", "blue", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "getGreen", "green", "", "isSrgb", "(J)Z", "isWideGamut", "getLuminance", "(I)F", "luminance", "getRed", "red", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ColorKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(26)
    public static final float component1(Color color) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, color)) == null) ? color.getComponent(0) : invokeL.floatValue;
    }

    public static final int component1(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? (i2 >> 24) & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, color)) == null) ? color.getComponent(1) : invokeL.floatValue;
    }

    public static final int component2(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? (i2 >> 16) & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, color)) == null) ? color.getComponent(2) : invokeL.floatValue;
    }

    public static final int component3(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? (i2 >> 8) & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, color)) == null) ? color.getComponent(3) : invokeL.floatValue;
    }

    public static final int component4(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? i2 & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace.Named named) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65548, null, i2, named)) == null) ? Color.convert(i2, ColorSpace.get(named)) : invokeIL.longValue;
    }

    @RequiresApi(26)
    public static final float getAlpha(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65554, null, j2)) == null) ? Color.alpha(j2) : invokeJ.floatValue;
    }

    public static final int getAlpha(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? (i2 >> 24) & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final float getBlue(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j2)) == null) ? Color.blue(j2) : invokeJ.floatValue;
    }

    public static final int getBlue(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) ? i2 & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65558, null, j2)) == null) {
            ColorSpace colorSpace = Color.colorSpace(j2);
            Intrinsics.checkExpressionValueIsNotNull(colorSpace, "Color.colorSpace(this)");
            return colorSpace;
        }
        return (ColorSpace) invokeJ.objValue;
    }

    @RequiresApi(26)
    public static final float getGreen(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65559, null, j2)) == null) ? Color.green(j2) : invokeJ.floatValue;
    }

    public static final int getGreen(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i2)) == null) ? (i2 >> 8) & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65561, null, i2)) == null) ? Color.luminance(i2) : invokeI.floatValue;
    }

    @RequiresApi(26)
    public static final float getRed(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65563, null, j2)) == null) ? Color.red(j2) : invokeJ.floatValue;
    }

    public static final int getRed(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) ? (i2 >> 16) & 255 : invokeI.intValue;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65565, null, j2)) == null) ? Color.isSrgb(j2) : invokeJ.booleanValue;
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65566, null, j2)) == null) ? Color.isWideGamut(j2) : invokeJ.booleanValue;
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color color2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, color, color2)) == null) {
            Color compositeColors = ColorUtils.compositeColors(color2, color);
            Intrinsics.checkExpressionValueIsNotNull(compositeColors, "ColorUtils.compositeColors(c, this)");
            return compositeColors;
        }
        return (Color) invokeLL.objValue;
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65568, null, i2)) == null) {
            Color valueOf = Color.valueOf(i2);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
            return valueOf;
        }
        return (Color) invokeI.objValue;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65570, null, j2)) == null) ? Color.toArgb(j2) : invokeJ.intValue;
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i2)) == null) ? Color.pack(i2) : invokeI.longValue;
    }

    @RequiresApi(26)
    public static final float component1(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j2)) == null) ? Color.red(j2) : invokeJ.floatValue;
    }

    @RequiresApi(26)
    public static final float component2(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) ? Color.green(j2) : invokeJ.floatValue;
    }

    @RequiresApi(26)
    public static final float component3(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j2)) == null) ? Color.blue(j2) : invokeJ.floatValue;
    }

    @RequiresApi(26)
    public static final float component4(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j2)) == null) ? Color.alpha(j2) : invokeJ.floatValue;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace colorSpace) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65549, null, i2, colorSpace)) == null) ? Color.convert(i2, colorSpace) : invokeIL.longValue;
    }

    @RequiresApi(26)
    public static final float getLuminance(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65562, null, j2)) == null) ? Color.luminance(j2) : invokeJ.floatValue;
    }

    @RequiresApi(26)
    public static final Color toColor(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65569, null, j2)) == null) {
            Color valueOf = Color.valueOf(j2);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
            return valueOf;
        }
        return (Color) invokeJ.objValue;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) ? Color.parseColor(str) : invokeL.intValue;
    }

    @RequiresApi(26)
    public static final long convertTo(long j2, ColorSpace.Named named) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65550, null, j2, named)) == null) ? Color.convert(j2, ColorSpace.get(named)) : invokeJL.longValue;
    }

    @RequiresApi(26)
    public static final long convertTo(long j2, ColorSpace colorSpace) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65551, null, j2, colorSpace)) == null) ? Color.convert(j2, colorSpace) : invokeJL.longValue;
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, color, named)) == null) {
            Color convert = color.convert(ColorSpace.get(named));
            Intrinsics.checkExpressionValueIsNotNull(convert, "convert(ColorSpace.get(colorSpace))");
            return convert;
        }
        return (Color) invokeLL.objValue;
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, color, colorSpace)) == null) {
            Color convert = color.convert(colorSpace);
            Intrinsics.checkExpressionValueIsNotNull(convert, "convert(colorSpace)");
            return convert;
        }
        return (Color) invokeLL.objValue;
    }
}
