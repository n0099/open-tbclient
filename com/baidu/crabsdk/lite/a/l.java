package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4737a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4738b;

    public static void a(Context context) {
        if (f4737a == null) {
            f4737a = context.getSharedPreferences("crablite_app_life", 0);
        }
        if (f4738b == null) {
            f4738b = f4737a.edit();
        }
    }

    public static void b(String str) {
        SharedPreferences.Editor editor = f4738b;
        if (editor != null) {
            editor.putInt("used_count_" + str, 0);
            com.baidu.crabsdk.lite.b.c.c(f4738b, false);
        }
    }

    public static void c(String str) {
        SharedPreferences.Editor editor = f4738b;
        editor.putInt("used_count_" + str, d(str) + 1);
        com.baidu.crabsdk.lite.b.c.c(f4738b, false);
    }

    public static int d(String str) {
        SharedPreferences sharedPreferences = f4737a;
        return sharedPreferences.getInt("used_count_" + str, 0);
    }
}
