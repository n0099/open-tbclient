package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes2.dex */
public final class ResUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Context f9049a;

    public static String getString(int i2) {
        Context context = f9049a;
        return context != null ? context.getString(i2) : "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            f9049a = context.getApplicationContext();
        }
    }
}
