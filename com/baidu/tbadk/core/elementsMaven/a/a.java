package com.baidu.tbadk.core.elementsMaven.a;

import android.graphics.Paint;
/* loaded from: classes.dex */
public class a {
    public static void a(Paint.FontMetricsInt fontMetricsInt, int i) {
        int i2 = fontMetricsInt.descent - fontMetricsInt.ascent;
        if (i2 > 0) {
            fontMetricsInt.descent = Math.round(((i * 1.0f) / i2) * fontMetricsInt.descent);
            fontMetricsInt.ascent = fontMetricsInt.descent - i;
        }
    }
}
