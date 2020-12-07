package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes9.dex */
public final class ResUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2716a;

    private ResUtils() {
    }

    public static String getString(int i) {
        Context context = f2716a;
        return context != null ? context.getString(i) : "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            f2716a = context.getApplicationContext();
        }
    }
}
