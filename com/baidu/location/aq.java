package com.baidu.location;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static final String f465a = aq.class.getSimpleName();

    public static String a(Context context) {
        String b = b(context);
        String b2 = ar.b(context);
        if (TextUtils.isEmpty(b2)) {
            b2 = "0";
        }
        return b + "|" + new StringBuffer(b2).reverse().toString();
    }

    private static String b(Context context) {
        return ar.a(context);
    }
}
