package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class Gradient {

    /* renamed from: a  reason: collision with root package name */
    public final int f7121a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f7122b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f7123c;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public final int f7125b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7126c;

        /* renamed from: d  reason: collision with root package name */
        public final float f7127d;

        public a(int i2, int i3, float f2) {
            this.f7125b = i2;
            this.f7126c = i3;
            this.f7127d = f2;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i2) {
        if (iArr == null || fArr == null) {
            throw new IllegalArgumentException("colors and startPoints should not be null");
        }
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        for (int i3 = 1; i3 < fArr.length; i3++) {
            if (fArr[i3] <= fArr[i3 - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            }
        }
        this.f7121a = i2;
        int[] iArr2 = new int[iArr.length];
        this.f7122b = iArr2;
        this.f7123c = new float[fArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(fArr, 0, this.f7123c, 0, fArr.length);
    }

    public static int a(int i2, int i3, float f2) {
        int alpha = (int) (((Color.alpha(i3) - Color.alpha(i2)) * f2) + Color.alpha(i2));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i3), Color.green(i3), Color.blue(i3), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i4 = 0; i4 < 3; i4++) {
            fArr3[i4] = ((fArr2[i4] - fArr[i4]) * f2) + fArr[i4];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>();
        if (this.f7123c[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.f7122b[0]), Color.green(this.f7122b[0]), Color.blue(this.f7122b[0])), this.f7122b[0], this.f7121a * this.f7123c[0]));
        }
        for (int i2 = 1; i2 < this.f7122b.length; i2++) {
            int i3 = i2 - 1;
            Integer valueOf = Integer.valueOf((int) (this.f7121a * this.f7123c[i3]));
            int[] iArr = this.f7122b;
            int i4 = iArr[i3];
            int i5 = iArr[i2];
            float[] fArr = this.f7123c;
            hashMap.put(valueOf, new a(i4, i5, (fArr[i2] - fArr[i3]) * this.f7121a));
        }
        float[] fArr2 = this.f7123c;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.f7121a * fArr2[length]));
            int[] iArr2 = this.f7122b;
            hashMap.put(valueOf2, new a(iArr2[length], iArr2[length], this.f7121a * (1.0f - this.f7123c[length])));
        }
        return hashMap;
    }

    public int[] a(double d2) {
        HashMap<Integer, a> a2 = a();
        int[] iArr = new int[this.f7121a];
        a aVar = a2.get(0);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7121a; i3++) {
            if (a2.containsKey(Integer.valueOf(i3))) {
                aVar = a2.get(Integer.valueOf(i3));
                i2 = i3;
            }
            iArr[i3] = a(aVar.f7125b, aVar.f7126c, (i3 - i2) / aVar.f7127d);
        }
        if (d2 != 1.0d) {
            for (int i4 = 0; i4 < this.f7121a; i4++) {
                int i5 = iArr[i4];
                iArr[i4] = Color.argb((int) (Color.alpha(i5) * d2), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
        return iArr;
    }
}
