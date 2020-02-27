package com.baidu.c.a.e;

import android.text.TextPaint;
import android.text.TextUtils;
/* loaded from: classes13.dex */
public class a {
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
