package com.baidu.adp.lib.util;

import android.graphics.Paint;
/* loaded from: classes.dex */
public class v {
    public static boolean a(float f, Paint paint, String str, int i) {
        return paint.measureText(str) >= ((float) i) * f;
    }

    public static int b(float f, Paint paint, String str, int i) {
        if (f == 0.0f || i == 0 || str == null || str.isEmpty()) {
            return 0;
        }
        return Math.min((int) Math.ceil(paint.measureText(str) / f), i);
    }
}
