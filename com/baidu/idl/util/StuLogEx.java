package com.baidu.idl.util;

import android.util.Log;
/* loaded from: classes14.dex */
public class StuLogEx {
    private static final boolean DEBUG_ENABLE = Log.isLoggable("stu", 3);
    public static final String TAG = "IDL";

    public static void v(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.v(TAG, str + str2);
        }
    }

    public static void d(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.d(TAG, str + str2);
        }
    }

    public static void i(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.i(TAG, str + str2);
        }
    }

    public static void w(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.w(TAG, str + str2);
        }
    }

    public static void e(String str, String str2) {
        Log.e(TAG, str + str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(TAG, str + str2, th);
    }
}
