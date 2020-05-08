package com.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {
    public final double CX;
    final int CY;
    public final int CZ;
    final double Da;
    public final double Db;
    @ColorInt
    public final int Dc;
    public final double Dd;
    public final boolean De;
    @ColorInt
    public final int color;
    public final String fontName;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.CX = d;
        this.CY = i;
        this.CZ = i2;
        this.Da = d2;
        this.Db = d3;
        this.color = i3;
        this.Dc = i4;
        this.Dd = d4;
        this.De = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.Da);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.CX)) * 31) + this.CY) * 31) + this.CZ) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
