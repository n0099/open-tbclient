package com.baidu.android.imrtc.utils;

import android.util.Log;
/* loaded from: classes12.dex */
public class LogUtils {
    private static String TAG = "rtcsdk";

    public static void d(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            Log.d(TAG, str + " : " + str2);
        }
    }

    public static void i(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            Log.i(TAG, str + " : " + str2);
        }
    }

    public static void v(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            Log.v(TAG, str + " : " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            Log.w(TAG, str + " : " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            Log.e(TAG, str + " : " + str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (RtcConstants.LOG_DEBUG) {
            Log.e(TAG, str + " : " + str2, th);
        }
    }
}
