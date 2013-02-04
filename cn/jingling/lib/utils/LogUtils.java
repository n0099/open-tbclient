package cn.jingling.lib.utils;

import android.util.Log;
/* loaded from: classes.dex */
public class LogUtils {
    private static boolean isLog = true;

    public static void close() {
        isLog = false;
    }

    public static void d(String str, String str2) {
        if (isLog) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isLog) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isLog) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (isLog) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isLog) {
            Log.w(str, str2);
        }
    }
}
