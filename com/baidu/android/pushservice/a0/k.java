package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.SharedPreferences;
import com.kuaishou.weapon.p0.u;
/* loaded from: classes.dex */
public class k {
    public static int a(Context context, String str, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst_bdservice_v1", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getInt(str, i) : context.getSharedPreferences(u.x, 0).getInt(str, i);
    }

    public static long a(Context context, String str, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst_bdservice_v1", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getLong(str, j) : context.getSharedPreferences(u.x, 0).getLong(str, j);
    }

    public static void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public static boolean a(Context context, String str) {
        return context.getSharedPreferences("pst_bdservice_v1", 0).contains(str) || context.getSharedPreferences(u.x, 0).contains(str);
    }

    public static int b(Context context, String str, int i) {
        return context.getSharedPreferences("pst_bdservice_v1", 0).getInt(str, i);
    }

    public static String b(Context context, String str) {
        return context.getSharedPreferences("pst_bdservice_v1", 0).getString(str, "");
    }

    public static void b(Context context, String str, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
            edit.putLong(str, j);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
