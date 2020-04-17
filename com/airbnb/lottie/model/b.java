package com.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {
    public final double CU;
    final int CV;
    public final int CW;
    final double CX;
    public final double CY;
    @ColorInt
    public final int CZ;
    public final double Da;
    public final boolean Db;
    @ColorInt
    public final int color;
    public final String fontName;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.CU = d;
        this.CV = i;
        this.CW = i2;
        this.CX = d2;
        this.CY = d3;
        this.color = i3;
        this.CZ = i4;
        this.Da = d4;
        this.Db = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.CX);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.CU)) * 31) + this.CV) * 31) + this.CW) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
