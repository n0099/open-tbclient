package com.baidu.adp.lib.util;

import android.graphics.Paint;
/* loaded from: classes.dex */
public class v {
    public static boolean a(float f, Paint paint, String str, int i) {
        float f2 = 0.0f;
        if (f == 0.0f || i == 0 || str == null || str.isEmpty() || paint == null) {
            return false;
        }
        if (!str.contains("\n")) {
            return paint.measureText(str) >= ((float) i) * f;
        }
        String[] split = str.split("\n");
        if (split.length <= i) {
            int i2 = 0;
            for (int i3 = 0; i3 < i && split.length > i3; i3++) {
                if (i3 < i - 1) {
                    float measureText = paint.measureText(split[i3]);
                    int ceil = (int) Math.ceil(measureText / f);
                    i2 += ceil;
                    if (i2 < 5) {
                        f2 += ceil * f;
                    } else {
                        f2 += measureText;
                    }
                } else {
                    i2++;
                    f2 += paint.measureText(split[i3]);
                }
                if (i2 >= 5) {
                    return f2 >= ((float) i) * f;
                }
            }
            return false;
        }
        return true;
    }

    public static int b(float f, Paint paint, String str, int i) {
        if (f == 0.0f || i == 0 || str == null || str.isEmpty()) {
            return 0;
        }
        return Math.min((int) Math.ceil(paint.measureText(str) / f), i);
    }
}
