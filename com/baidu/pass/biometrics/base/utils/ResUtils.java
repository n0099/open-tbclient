package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes3.dex */
public final class ResUtils {
    public static Context a;

    public static String getString(int i) {
        Context context = a;
        if (context != null) {
            return context.getString(i);
        }
        return "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }
}
