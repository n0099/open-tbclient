package com.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class b {
    @ColorInt
    public final int color;
    public final String fontName;
    public final double ho;
    final int hp;
    public final int hq;
    final double hr;
    public final double hs;
    @ColorInt
    public final int ht;
    public final double hu;
    public final boolean hv;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.ho = d;
        this.hp = i;
        this.hq = i2;
        this.hr = d2;
        this.hs = d3;
        this.color = i3;
        this.ht = i4;
        this.hu = d4;
        this.hv = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.hr);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.ho)) * 31) + this.hp) * 31) + this.hq) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
