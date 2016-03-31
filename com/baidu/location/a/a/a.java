package com.baidu.location.a.a;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: if  reason: not valid java name */
    private static final String f26if = a.class.getSimpleName();

    private static String a(Context context) {
        return b.a(context);
    }

    /* renamed from: if  reason: not valid java name */
    public static String m65if(Context context) {
        String a = a(context);
        String H = b.H(context);
        if (TextUtils.isEmpty(H)) {
            H = "0";
        }
        return a + "|" + new StringBuffer(H).reverse().toString();
    }
}
