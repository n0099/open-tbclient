package com.baidu.android.nebula.a;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class j {
    private static final String a = j.class.getSimpleName();

    public static String a(Context context) {
        String b = b(context);
        String b2 = b.b(context);
        if (TextUtils.isEmpty(b2)) {
            b2 = "0";
        }
        return b + "|" + new StringBuffer(b2).reverse().toString();
    }

    private static String b(Context context) {
        return b.a(context);
    }
}
