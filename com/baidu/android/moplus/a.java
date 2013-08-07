package com.baidu.android.moplus;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class a {
    public static void a(Context context, boolean z) {
        int i = z ? 0 : 12;
        SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
        edit.putInt("nd_restart", i);
        edit.commit();
    }

    public static boolean a(Context context) {
        return 12 > context.getSharedPreferences("pst", 0).getInt("nd_restart", 0);
    }

    public static String b(Context context) {
        return context.getSharedPreferences("pst", 0).getString("s_e", "default");
    }

    public static void b(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        String str = z ? "enabled" : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("s_e", str);
        edit.commit();
    }
}
