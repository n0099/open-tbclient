package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes5.dex */
public final class ResUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Context f4017a;

    private ResUtils() {
    }

    public static String getString(int i) {
        Context context = f4017a;
        return context != null ? context.getString(i) : "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            f4017a = context.getApplicationContext();
        }
    }
}
