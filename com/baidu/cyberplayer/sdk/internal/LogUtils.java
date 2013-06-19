package com.baidu.cyberplayer.sdk.internal;

import android.util.Log;
/* loaded from: classes.dex */
public class LogUtils {
    public static void dumpException(Throwable th) {
        if (canOutput(5)) {
            StringBuilder sb = new StringBuilder(256);
            sb.append(" Got exception \"");
            sb.append(th.toString());
            sb.append("\" on Android ");
            sb.append(VersionUtils.getCurrentVersion());
            sb.append("\n");
            System.out.println(sb.toString());
            th.printStackTrace(System.out);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        a(2, str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        a(3, str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        a(4, str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        a(5, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        a(6, str, str2, objArr);
    }

    public static void wtf(String str, String str2, Object... objArr) {
        a(7, str, str2, objArr);
    }

    public static boolean canOutput(int i) {
        return 2 <= i;
    }

    private static void a(int i, String str, String str2, Object... objArr) {
        if (2 <= i && str != null && str2 != null) {
            Log.println(i, str, String.format(str2, objArr));
        }
    }
}
