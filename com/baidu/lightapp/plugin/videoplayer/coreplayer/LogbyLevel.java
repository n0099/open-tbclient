package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import android.util.Log;
/* loaded from: classes.dex */
public class LogbyLevel {
    private static int mLogLevel = 0;

    public static void d(String str, String str2) {
        if (mLogLevel < 4 || mLogLevel > 5) {
            return;
        }
        Log.d(str, str2);
    }

    public static void e(String str, String str2) {
        if (mLogLevel < 1 || mLogLevel > 5) {
            return;
        }
        Log.w(str, str2);
    }

    public static void i(String str, String str2) {
        if (mLogLevel < 3 || mLogLevel > 5) {
            return;
        }
        Log.i(str, str2);
    }

    public static void setLogLevel(int i) {
        if (i < 0 || i > 5) {
            return;
        }
        mLogLevel = i;
    }

    public static void v(String str, String str2) {
        if (mLogLevel == 5) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (mLogLevel < 2 || mLogLevel > 5) {
            return;
        }
        Log.w(str, str2);
    }
}
