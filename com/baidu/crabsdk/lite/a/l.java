package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4883a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4884b;

    public static void a(Context context) {
        if (f4883a == null) {
            f4883a = context.getSharedPreferences("crablite_app_life", 0);
        }
        if (f4884b == null) {
            f4884b = f4883a.edit();
        }
    }

    public static void b(String str) {
        SharedPreferences.Editor editor = f4884b;
        if (editor != null) {
            editor.putInt("used_count_" + str, 0);
            com.baidu.crabsdk.lite.b.c.c(f4884b, false);
        }
    }

    public static void c(String str) {
        SharedPreferences.Editor editor = f4884b;
        editor.putInt("used_count_" + str, d(str) + 1);
        com.baidu.crabsdk.lite.b.c.c(f4884b, false);
    }

    public static int d(String str) {
        SharedPreferences sharedPreferences = f4883a;
        return sharedPreferences.getInt("used_count_" + str, 0);
    }
}
