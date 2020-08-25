package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes20.dex */
public final class ResUtils {
    private static Context a;

    private ResUtils() {
    }

    public static String getString(int i) {
        Context context = a;
        return context != null ? context.getString(i) : "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }
}
