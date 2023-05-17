package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class Gradient {
    public float[] a;
    public final int b;
    public final int[] c;
    public final float[] d;

    /* loaded from: classes3.dex */
    public class a {
        public final int b;
        public final int c;
        public final float d;

        public a(int i, int i2, float f) {
            this.b = i;
            this.c = i2;
            this.d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i) {
        int[] a2 = com.baidu.platform.comapi.util.e.a(iArr);
        if (a2 != null && fArr != null) {
            if (a2.length == fArr.length) {
                if (a2.length != 0) {
                    for (int i2 = 1; i2 < fArr.length; i2++) {
                        if (fArr[i2] <= fArr[i2 - 1]) {
                            throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
                        }
                    }
                    this.b = i;
                    int[] iArr2 = new int[a2.length];
                    this.c = iArr2;
                    this.d = new float[fArr.length];
                    System.arraycopy(a2, 0, iArr2, 0, a2.length);
                    System.arraycopy(fArr, 0, this.d, 0, fArr.length);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: No colors have been defined");
            }
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should be same length");
        }
        throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should not be null");
    }

    public static int a(int i, int i2, float f) {
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

    private HashMap<Integer, a> b() {
        HashMap<Integer, a> hashMap = new HashMap<>();
        if (this.d[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.c[0]), Color.green(this.c[0]), Color.blue(this.c[0])), this.c[0], this.b * this.d[0]));
        }
        for (int i = 1; i < this.c.length; i++) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf((int) (this.b * this.d[i2]));
            int[] iArr = this.c;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float[] fArr = this.d;
            hashMap.put(valueOf, new a(i3, i4, (fArr[i] - fArr[i2]) * this.b));
        }
        float[] fArr2 = this.d;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.b * fArr2[length]));
            int[] iArr2 = this.c;
            hashMap.put(valueOf2, new a(iArr2[length], iArr2[length], this.b * (1.0f - this.d[length])));
        }
        return hashMap;
    }

    public float[] a() {
        float[] fArr = this.a;
        if (fArr == null) {
            this.a = new float[this.b];
            int i = 0;
            while (i < this.b) {
                int i2 = i + 1;
                this.a[i] = i2 * 0.001f;
                i = i2;
            }
            return this.a;
        }
        return fArr;
    }

    public int[] getColors() {
        return this.c;
    }

    public float[] getStartPoints() {
        return this.d;
    }

    public int[] a(double d) {
        HashMap<Integer, a> b = b();
        int[] iArr = new int[this.b];
        a aVar = b.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (b.containsKey(Integer.valueOf(i2))) {
                aVar = b.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = a(aVar.b, aVar.c, (i2 - i) / aVar.d);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.b; i3++) {
                int i4 = iArr[i3];
                iArr[i3] = Color.argb((int) (Color.alpha(i4) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }
}
