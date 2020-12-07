package com.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class b {
    public final double Fp;
    final int Fq;
    final double Fr;
    public final double Fs;
    @ColorInt
    public final int Ft;
    public final double Fu;
    public final boolean Fv;
    @ColorInt
    public final int color;
    public final String fontName;
    public final String text;
    public final int tracking;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.Fp = d;
        this.Fq = i;
        this.tracking = i2;
        this.Fr = d2;
        this.Fs = d3;
        this.color = i3;
        this.Ft = i4;
        this.Fu = d4;
        this.Fv = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.Fr);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.Fp)) * 31) + this.Fq) * 31) + this.tracking) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
