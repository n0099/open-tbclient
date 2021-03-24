package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes2.dex */
public final class ResUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Context f9571a;

    public static String getString(int i) {
        Context context = f9571a;
        return context != null ? context.getString(i) : "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            f9571a = context.getApplicationContext();
        }
    }
}
