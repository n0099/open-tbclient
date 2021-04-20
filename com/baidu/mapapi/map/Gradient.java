package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class Gradient {

    /* renamed from: a  reason: collision with root package name */
    public final int f6882a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f6883b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f6884c;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public final int f6886b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6887c;

        /* renamed from: d  reason: collision with root package name */
        public final float f6888d;

        public a(int i, int i2, float f2) {
            this.f6886b = i;
            this.f6887c = i2;
            this.f6888d = f2;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i) {
        if (iArr == null || fArr == null) {
            throw new IllegalArgumentException("colors and startPoints should not be null");
        }
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        for (int i2 = 1; i2 < fArr.length; i2++) {
            if (fArr[i2] <= fArr[i2 - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            }
        }
        this.f6882a = i;
        int[] iArr2 = new int[iArr.length];
        this.f6883b = iArr2;
        this.f6884c = new float[fArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(fArr, 0, this.f6884c, 0, fArr.length);
    }

    public static int a(int i, int i2, float f2) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f2) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f2) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>();
        if (this.f6884c[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.f6883b[0]), Color.green(this.f6883b[0]), Color.blue(this.f6883b[0])), this.f6883b[0], this.f6882a * this.f6884c[0]));
        }
        for (int i = 1; i < this.f6883b.length; i++) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf((int) (this.f6882a * this.f6884c[i2]));
            int[] iArr = this.f6883b;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float[] fArr = this.f6884c;
            hashMap.put(valueOf, new a(i3, i4, (fArr[i] - fArr[i2]) * this.f6882a));
        }
        float[] fArr2 = this.f6884c;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.f6882a * fArr2[length]));
            int[] iArr2 = this.f6883b;
            hashMap.put(valueOf2, new a(iArr2[length], iArr2[length], this.f6882a * (1.0f - this.f6884c[length])));
        }
        return hashMap;
    }

    public int[] a(double d2) {
        HashMap<Integer, a> a2 = a();
        int[] iArr = new int[this.f6882a];
        a aVar = a2.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.f6882a; i2++) {
            if (a2.containsKey(Integer.valueOf(i2))) {
                aVar = a2.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = a(aVar.f6886b, aVar.f6887c, (i2 - i) / aVar.f6888d);
        }
        if (d2 != 1.0d) {
            for (int i3 = 0; i3 < this.f6882a; i3++) {
                int i4 = iArr[i3];
                iArr[i3] = Color.argb((int) (Color.alpha(i4) * d2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }
}
