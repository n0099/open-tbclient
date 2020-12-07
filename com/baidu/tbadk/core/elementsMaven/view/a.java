package com.baidu.tbadk.core.elementsMaven.view;

import android.graphics.Paint;
import android.text.Spanned;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes.dex */
public class a {
    public static void a(Paint.FontMetricsInt fontMetricsInt, int i) {
        int i2 = fontMetricsInt.descent - fontMetricsInt.ascent;
        if (i2 > 0) {
            fontMetricsInt.descent = Math.round(((i * 1.0f) / i2) * fontMetricsInt.descent);
            fontMetricsInt.ascent = fontMetricsInt.descent - i;
        }
    }

    public static boolean k(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            return ((EMTextView.a[]) spanned.getSpans(0, spanned.length(), EMTextView.a.class)).length > 0;
        }
        return false;
    }
}
