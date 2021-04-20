package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DocumentData {

    /* renamed from: a  reason: collision with root package name */
    public final String f1579a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1580b;

    /* renamed from: c  reason: collision with root package name */
    public final float f1581c;

    /* renamed from: d  reason: collision with root package name */
    public final Justification f1582d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1583e;

    /* renamed from: f  reason: collision with root package name */
    public final float f1584f;

    /* renamed from: g  reason: collision with root package name */
    public final float f1585g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f1586h;
    @ColorInt
    public final int i;
    public final float j;
    public final boolean k;

    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f2, Justification justification, int i, float f3, float f4, @ColorInt int i2, @ColorInt int i3, float f5, boolean z) {
        this.f1579a = str;
        this.f1580b = str2;
        this.f1581c = f2;
        this.f1582d = justification;
        this.f1583e = i;
        this.f1584f = f3;
        this.f1585g = f4;
        this.f1586h = i2;
        this.i = i3;
        this.j = f5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f1579a.hashCode() * 31) + this.f1580b.hashCode()) * 31) + this.f1581c)) * 31) + this.f1582d.ordinal()) * 31) + this.f1583e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f1584f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f1586h;
    }
}
