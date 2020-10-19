package com.baidu.g.a.e;

import android.text.TextPaint;
import android.text.TextUtils;
/* loaded from: classes26.dex */
public class a {
    public static int dn(int i) {
        return (int) ((i * 16.0d) / 9.0d);
    }

    /* renamed from: do  reason: not valid java name */
    public static int m21do(int i) {
        return (int) ((i * 9.0d) / 16.0d);
    }

    public static String a(String str, String str2, float f, TextPaint textPaint) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (textPaint == null) {
            textPaint = new TextPaint();
        }
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f - textPaint.measureText("  " + str2), TextUtils.TruncateAt.END);
        if (ellipsize != null) {
            return ellipsize.toString() + "  " + str2;
        }
        return str2;
    }
}
