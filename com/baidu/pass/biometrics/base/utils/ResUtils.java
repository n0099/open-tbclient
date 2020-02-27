package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes6.dex */
public final class ResUtils {
    private static Context appContext = null;

    private ResUtils() {
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            appContext = context.getApplicationContext();
        }
    }

    public static String getString(int i) {
        return appContext != null ? appContext.getString(i) : "";
    }
}
