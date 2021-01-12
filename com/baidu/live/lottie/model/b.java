package com.baidu.live.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class b {
    public final double Fc;
    final int Fd;
    final double Fe;
    public final double Ff;
    public final double Fg;
    public final boolean Fh;
    @ColorInt
    public final int color;
    public final String fontName;
    @ColorInt
    public final int strokeColor;
    public final String text;
    public final int tracking;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.Fc = d;
        this.Fd = i;
        this.tracking = i2;
        this.Fe = d2;
        this.Ff = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.Fg = d4;
        this.Fh = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.Fe);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.Fc)) * 31) + this.Fd) * 31) + this.tracking) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
