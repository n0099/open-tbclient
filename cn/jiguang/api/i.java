package cn.jiguang.api;

import android.content.Context;
/* loaded from: classes3.dex */
public class i {
    public static void c(Context context, String str, boolean z) {
        cn.jiguang.d.a.d.a(context, str, Boolean.valueOf(z));
    }

    public static void d(Context context, String str, int i) {
        cn.jiguang.d.a.d.a(context, str, Integer.valueOf(i));
    }

    public static void e(Context context, String str, long j) {
        cn.jiguang.d.a.d.a(context, str, Long.valueOf(j));
    }

    public static void f(Context context, String str, String str2) {
        cn.jiguang.d.a.d.a(context, str, str2);
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return ((Boolean) cn.jiguang.d.a.d.b(context, str, Boolean.valueOf(z))).booleanValue();
    }

    public static int getInt(Context context, String str, int i) {
        return ((Integer) cn.jiguang.d.a.d.b(context, str, Integer.valueOf(i))).intValue();
    }

    public static long getLong(Context context, String str, long j) {
        return ((Long) cn.jiguang.d.a.d.b(context, str, Long.valueOf(j))).longValue();
    }

    public static String getString(Context context, String str, String str2) {
        return (String) cn.jiguang.d.a.d.b(context, str, str2);
    }
}
