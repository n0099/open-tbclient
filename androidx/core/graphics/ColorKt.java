package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\b\u0010\u0005\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\b\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\t\u0010\u0005\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\t\u0010\u0007\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u0003\u001a\u0014\u0010\n\u001a\u00020\u0004*\u00020\u0004H\u0086\n¢\u0006\u0004\b\n\u0010\u0005\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0006H\u0087\n¢\u0006\u0004\b\n\u0010\u0007\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0087\f¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000fH\u0087\f¢\u0006\u0004\b\r\u0010\u0010\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0087\f¢\u0006\u0004\b\r\u0010\u0011\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000fH\u0087\f¢\u0006\u0004\b\r\u0010\u0012\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0087\f¢\u0006\u0004\b\r\u0010\u0013\u001a\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u000fH\u0087\f¢\u0006\u0004\b\r\u0010\u0014\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0018\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u001dH\u0087\b¢\u0006\u0004\b\u001b\u0010\u001e\u001a\u0014\u0010\u001f\u001a\u00020\u0006*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001f\u0010 \"\u0018\u0010\"\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0005\"\u0018\u0010\"\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0007\"\u0018\u0010$\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0005\"\u0018\u0010$\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0007\"\u0018\u0010\f\u001a\u00020\u000b*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0018\u0010(\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010\u0005\"\u0018\u0010(\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010\u0007\"\u0018\u0010*\u001a\u00020)*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010,\u001a\u00020)*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010+\"\u0018\u0010/\u001a\u00020\u0001*\u00020\u00048Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0018\u0010/\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010\u0007\"\u0018\u00101\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010\u0005\"\u0018\u00101\u001a\u00020\u0001*\u00020\u00068Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010\u0007¨\u00062"}, d2 = {"Landroid/graphics/Color;", "", "component1", "(Landroid/graphics/Color;)F", "", "(I)I", "", "(J)F", "component2", "component3", "component4", "Landroid/graphics/ColorSpace;", "colorSpace", "convertTo", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace;)Landroid/graphics/Color;", "Landroid/graphics/ColorSpace$Named;", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace$Named;)Landroid/graphics/Color;", "(ILandroid/graphics/ColorSpace;)J", "(ILandroid/graphics/ColorSpace$Named;)J", "(JLandroid/graphics/ColorSpace;)J", "(JLandroid/graphics/ColorSpace$Named;)J", "c", "plus", "(Landroid/graphics/Color;Landroid/graphics/Color;)Landroid/graphics/Color;", "toColor", "(I)Landroid/graphics/Color;", "(J)Landroid/graphics/Color;", "toColorInt", "(J)I", "", "(Ljava/lang/String;)I", "toColorLong", "(I)J", "getAlpha", "alpha", "getBlue", "blue", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "getGreen", "green", "", "isSrgb", "(J)Z", "isWideGamut", "getLuminance", "(I)F", "luminance", "getRed", "red", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(Color color) {
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace.Named named) {
        return Color.convert(i2, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = Color.colorSpace(j);
        Intrinsics.checkExpressionValueIsNotNull(colorSpace, "Color.colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return Color.green(j);
    }

    public static final int getGreen(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i2) {
        return Color.luminance(i2);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return Color.red(j);
    }

    public static final int getRed(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return Color.isWideGamut(j);
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color color2) {
        Color compositeColors = ColorUtils.compositeColors(color2, color);
        Intrinsics.checkExpressionValueIsNotNull(compositeColors, "ColorUtils.compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i2) {
        Color valueOf = Color.valueOf(i2);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j) {
        return Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i2) {
        return Color.pack(i2);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace colorSpace) {
        return Color.convert(i2, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return Color.luminance(j);
    }

    @RequiresApi(26)
    public static final Color toColor(long j) {
        Color valueOf = Color.valueOf(j);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace.Named named) {
        return Color.convert(j, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace colorSpace) {
        return Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        Color convert = color.convert(ColorSpace.get(named));
        Intrinsics.checkExpressionValueIsNotNull(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        Color convert = color.convert(colorSpace);
        Intrinsics.checkExpressionValueIsNotNull(convert, "convert(colorSpace)");
        return convert;
    }
}
