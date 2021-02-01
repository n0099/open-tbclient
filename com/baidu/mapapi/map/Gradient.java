package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class Gradient {

    /* renamed from: a  reason: collision with root package name */
    private final int f2707a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f2708b;
    private final float[] c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private final int f2710b;
        private final int c;
        private final float d;

        private a(int i, int i2, float f) {
            this.f2710b = i;
            this.c = i2;
            this.d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
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
        this.f2707a = i;
        this.f2708b = new int[iArr.length];
        this.c = new float[fArr.length];
        System.arraycopy(iArr, 0, this.f2708b, 0, iArr.length);
        System.arraycopy(fArr, 0, this.c, 0, fArr.length);
    }

    private static int a(int i, int i2, float f) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
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
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>();
        if (this.c[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.f2708b[0]), Color.green(this.f2708b[0]), Color.blue(this.f2708b[0])), this.f2708b[0], this.c[0] * this.f2707a));
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2708b.length) {
                break;
            }
            hashMap.put(Integer.valueOf((int) (this.f2707a * this.c[i2 - 1])), new a(this.f2708b[i2 - 1], this.f2708b[i2], (this.c[i2] - this.c[i2 - 1]) * this.f2707a));
            i = i2 + 1;
        }
        if (this.c[this.c.length - 1] != 1.0f) {
            int length = this.c.length - 1;
            hashMap.put(Integer.valueOf((int) (this.f2707a * this.c[length])), new a(this.f2708b[length], this.f2708b[length], this.f2707a * (1.0f - this.c[length])));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(double d) {
        HashMap<Integer, a> a2 = a();
        int[] iArr = new int[this.f2707a];
        int i = 0;
        a aVar = a2.get(0);
        for (int i2 = 0; i2 < this.f2707a; i2++) {
            if (a2.containsKey(Integer.valueOf(i2))) {
                i = i2;
                aVar = a2.get(Integer.valueOf(i2));
            }
            iArr[i2] = a(aVar.f2710b, aVar.c, (i2 - i) / aVar.d);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.f2707a; i3++) {
                int i4 = iArr[i3];
                iArr[i3] = Color.argb((int) (Color.alpha(i4) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }
}
