package com.baidu.android.imrtc.utils;

import android.util.Log;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes2.dex */
public class LogUtils {
    public static String TAG = "rtcsdk";

    public static void d(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            String str3 = TAG;
            Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void e(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            String str3 = TAG;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void i(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            String str3 = TAG;
            Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void v(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            String str3 = TAG;
            Log.v(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void w(String str, String str2) {
        if (RtcConstants.LOG_DEBUG) {
            String str3 = TAG;
            Log.w(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (RtcConstants.LOG_DEBUG) {
            String str3 = TAG;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
        }
    }
}
