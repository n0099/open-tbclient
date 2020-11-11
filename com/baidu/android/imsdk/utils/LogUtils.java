package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes18.dex */
public class LogUtils {
    public static String TAG = "imsdk";
    public static int LOG_LEVEL_E = 0;
    public static int LOG_LEVEL_W = 1;
    public static int LOG_LEVEL_I = 2;
    public static int LOG_LEVEL_D = 3;
    public static int LOG_LEVEL_V = 4;
    public static int mLoglevel = LOG_LEVEL_D;
    public static boolean mIsWriteToFile = false;
    private static Context sContext = null;

    public static void init(Context context, int i, boolean z) {
        mLoglevel = i;
        mIsWriteToFile = z;
        sContext = context;
        LogFile.getInstance(context);
    }

    public static void d(String str, String str2) {
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_D) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + " : " + str2 + "\n").getBytes());
                return;
            }
            Log.d(TAG, str + " : " + str2);
        }
    }

    public static void i(String str, String str2) {
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_I) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + " : " + str2 + "\n").getBytes());
                return;
            }
            Log.i(TAG, str + " : " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_I) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + " : " + str2 + "\n").getBytes());
                return;
            }
            Log.w(TAG, str + " : " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_E) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + " : " + str2 + "\n").getBytes());
                return;
            }
            Log.e(TAG, str + " : " + str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_E) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + " : " + str2 + "\n").getBytes());
                return;
            }
            Log.e(TAG, str + " : " + str2, th);
        }
    }

    public static void enter() {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_D && (stackTrace = new Throwable().getStackTrace()) != null && 2 <= stackTrace.length && (stackTraceElement = stackTrace[1]) != null) {
            d(stackTraceElement.getClassName(), "====>" + stackTraceElement.getMethodName());
        }
    }

    public static void enter(String str) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_D && (stackTrace = new Throwable().getStackTrace()) != null && 2 <= stackTrace.length && (stackTraceElement = stackTrace[1]) != null) {
            d(stackTraceElement.getClassName(), str + "====>" + stackTraceElement.getMethodName());
        }
    }

    public static void leave() {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_D && (stackTrace = new Throwable().getStackTrace()) != null && 2 <= stackTrace.length && (stackTraceElement = stackTrace[1]) != null) {
            d(stackTraceElement.getClassName(), "<====" + stackTraceElement.getMethodName());
        }
    }

    public static void leave(String str) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_D && (stackTrace = new Throwable().getStackTrace()) != null && 2 <= stackTrace.length && (stackTraceElement = stackTrace[1]) != null) {
            d(stackTraceElement.getClassName(), str + "<====" + stackTraceElement.getMethodName());
        }
    }

    private static String currentTime() {
        return new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss   ").format(new Date(System.currentTimeMillis()));
    }

    public static String fileName() {
        return new SimpleDateFormat("yyyyMMddHH").format(new Date(System.currentTimeMillis()));
    }
}
