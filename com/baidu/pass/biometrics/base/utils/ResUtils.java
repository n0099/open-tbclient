package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes11.dex */
public final class ResUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2714a;

    private ResUtils() {
    }

    public static String getString(int i) {
        Context context = f2714a;
        return context != null ? context.getString(i) : "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            f2714a = context.getApplicationContext();
        }
    }
}
