package com.baidu.cyberplayer.sdk;

import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.YalogWrap;
/* loaded from: classes3.dex */
public class CyberLog {
    public static final int LOG_DEBUG = 3;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 4;
    public static final int LOG_MAX = 7;
    public static final int LOG_VERBOSE = 2;
    public static final int LOG_WARN = 5;
    public static final int LOG_YALOG = 9;
    public static final String TAG = "duplayer-";
    public static int sLogLevel = 1;
    public static int sYalogLevel = 6;

    @Keep
    public static int getLogLevel() {
        return sLogLevel;
    }

    @Keep
    public static void d(String str, String str2) {
        if (3 >= sYalogLevel) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(3, TAG + str, str2);
        }
        if (7 - sLogLevel <= 3) {
            Log.i(TAG + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2) {
        if (6 >= sYalogLevel) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(6, TAG + str, str2);
        }
        if (7 - sLogLevel <= 6) {
            Log.e(TAG + str, str2);
        }
    }

    @Keep
    public static void i(String str, String str2) {
        if (4 >= sYalogLevel) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(4, TAG + str, str2);
        }
        if (7 - sLogLevel <= 4) {
            Log.i(TAG + str, str2);
        }
    }

    @Keep
    public static void v(String str, String str2) {
        if (2 >= sYalogLevel) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(2, TAG + str, str2);
        }
        if (7 - sLogLevel <= 2) {
            Log.v(TAG + str, str2);
        }
    }

    @Keep
    public static void w(String str, String str2) {
        if (5 >= sYalogLevel) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(5, TAG + str, str2);
        }
        if (7 - sLogLevel <= 5) {
            Log.w(TAG + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2, Throwable th) {
        if (6 >= sYalogLevel) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(6, TAG + str, str2);
        }
        if (7 - sLogLevel <= 6) {
            Log.e(TAG + str, str2, th);
        }
    }

    public static void setLogLevel(int i) {
        sLogLevel = i;
    }

    public static void setYalogLevel(int i) {
        sYalogLevel = i;
    }

    @Keep
    public static void y(String str, String str2) {
        YalogWrap yalogWrap = YalogWrap.getInstance();
        yalogWrap.writeYalog(9, TAG + str, str2);
    }
}
