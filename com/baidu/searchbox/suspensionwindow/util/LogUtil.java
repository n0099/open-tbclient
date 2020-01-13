package com.baidu.searchbox.suspensionwindow.util;

import android.util.Log;
/* loaded from: classes12.dex */
public class LogUtil {
    public static final boolean DEBUG = false;
    private static final String TAG = "suspension-window";

    public static void i(String str) {
        Log.i(TAG, str);
    }

    public static void i(String str, String str2) {
        Log.i(str, str2);
    }

    public static void d(String str) {
        Log.d(TAG, str);
    }

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void e(String str) {
        Log.e(TAG, str);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }
}
