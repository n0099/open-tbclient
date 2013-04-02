package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class b {
    public static String a(Context context) {
        return context.getSharedPreferences("pst", 0).getString("s_e", "default");
    }

    public static void a(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        String str = z ? "enabled" : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("s_e", str);
        edit.commit();
    }

    public static void b(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
        edit.putBoolean("c_e", z);
        edit.commit();
    }

    public static boolean b(Context context) {
        return com.baidu.android.pushservice.util.d.b(context, context.getPackageName(), "DenyConnection");
    }
}
