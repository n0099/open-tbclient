package com.baidu.lcp.sdk.d;

import android.util.Log;
/* loaded from: classes3.dex */
public class d {
    private static String TAG = "lcpsdk";

    public static void d(String str, String str2) {
        if (b.LOG_DEBUG) {
            Log.d(TAG, str + " : " + str2);
        }
    }

    public static void i(String str, String str2) {
        if (b.LOG_DEBUG) {
            Log.i(TAG, str + " : " + str2);
        }
    }

    public static void v(String str, String str2) {
        if (b.LOG_DEBUG) {
            Log.v(TAG, str + " : " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (b.LOG_DEBUG) {
            Log.w(TAG, str + " : " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (b.LOG_DEBUG) {
            Log.e(TAG, str + " : " + str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (b.LOG_DEBUG) {
            Log.e(TAG, str + " : " + str2, th);
        }
    }
}
