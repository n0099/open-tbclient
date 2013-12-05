package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f698a = 600;
    public static int b = 30;
    public static int c = 3;

    public static void a(Context context, Intent intent) {
        if (a()) {
            Log.d("Constants", "start service: com.baidu.android.pushservice.PushService");
        }
        intent.setClass(context, PushService.class);
        context.startService(intent);
    }

    public static void a(Context context, boolean z) {
        int i = z ? 0 : 13;
        SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
        edit.putInt("nd_restart", i);
        edit.commit();
    }

    public static boolean a() {
        return PushSettings.c();
    }

    public static boolean a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "com.baidu.android.pushservice.PushSettings.internal_debug_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            return false;
        }
    }

    public static void b(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        String str = z ? "enabled" : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("s_e", str);
        edit.commit();
    }

    public static boolean b(Context context) {
        return 13 > context.getSharedPreferences("pst", 0).getInt("nd_restart", 0);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("pst", 0).getString("s_e", "default");
    }

    public static void c(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
        edit.putBoolean("c_e", z);
        edit.commit();
    }
}
