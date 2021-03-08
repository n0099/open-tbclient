package com.baidu.live.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class b {
    public final boolean GA;
    public final double Gv;
    final int Gw;
    final double Gx;
    public final double Gy;
    public final double Gz;
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
        this.Gv = d;
        this.Gw = i;
        this.tracking = i2;
        this.Gx = d2;
        this.Gy = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.Gz = d4;
        this.GA = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.Gx);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.Gv)) * 31) + this.Gw) * 31) + this.tracking) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
