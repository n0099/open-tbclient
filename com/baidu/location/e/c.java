package com.baidu.location.e;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c {
    public static int a(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).get(2).floatValue() > 0.0f) {
                i++;
            }
        }
        return i;
    }

    public static int b(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).get(2).floatValue() >= 15.0f) {
                i++;
            }
        }
        return i;
    }

    public static int c(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).get(2).floatValue() >= 20.0f) {
                i++;
            }
        }
        return i;
    }

    public static int d(ArrayList<ArrayList<Float>> arrayList) {
        float f = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).get(2).floatValue() > 0.0f) {
                f += arrayList.get(i).get(2).floatValue();
            }
        }
        return Math.round(f);
    }

    public static int e(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(d(arrayList) / a(arrayList));
    }

    public static int f(ArrayList<ArrayList<Float>> arrayList) {
        float f = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).get(2).floatValue() > 0.0f) {
                f += arrayList.get(i).get(1).floatValue() * arrayList.get(i).get(2).floatValue();
            }
        }
        return Math.round(f);
    }

    public static int g(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(f(arrayList) / a(arrayList));
    }

    public static int h(ArrayList<ArrayList<Float>> arrayList) {
        int[] iArr = new int[37];
        for (int i = 0; i < arrayList.size(); i++) {
            int ceil = (int) Math.ceil(arrayList.get(i).get(0).floatValue() / 10.0f);
            iArr[ceil] = iArr[ceil] + 1;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= 36; i3++) {
            if (iArr[i3] > 0) {
                i2++;
            }
        }
        return Math.round((i2 / 36.0f) * 1000.0f);
    }
}
