package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class b {
    public static void a(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pushservice.mysetting", 0).edit();
        edit.putBoolean("service_enabled", z);
        edit.commit();
    }

    public static boolean a(Context context) {
        return context.getSharedPreferences("pushservice.mysetting", 0).getBoolean("service_enabled", true);
    }
}
