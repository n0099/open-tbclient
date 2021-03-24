package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class LogUtils {
    public static int LOG_LEVEL_D = 3;
    public static int LOG_LEVEL_E = 0;
    public static int LOG_LEVEL_I = 2;
    public static int LOG_LEVEL_V = 4;
    public static int LOG_LEVEL_W = 1;
    public static String TAG = "imsdk";
    public static boolean mIsWriteToFile = false;
    public static int mLoglevel = 3;
    public static Context sContext;

    public static String currentTime() {
        return new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss   ").format(new Date(System.currentTimeMillis()));
    }

    public static void d(String str, String str2) {
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D) {
            return;
        }
        if (mIsWriteToFile) {
            LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + "\n").getBytes());
            return;
        }
        String str3 = TAG;
        Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
    }

    public static void e(String str, String str2) {
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_E) {
            return;
        }
        if (mIsWriteToFile) {
            LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + "\n").getBytes());
            return;
        }
        String str3 = TAG;
        Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
    }

    public static void enter() {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, "====>" + methodName);
    }

    public static String fileName() {
        return new SimpleDateFormat("yyyyMMddHH").format(new Date(System.currentTimeMillis()));
    }

    public static void i(String str, String str2) {
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_I) {
            return;
        }
        if (mIsWriteToFile) {
            LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + "\n").getBytes());
            return;
        }
        String str3 = TAG;
        Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
    }

    public static void init(Context context, int i, boolean z) {
        mLoglevel = i;
        mIsWriteToFile = z;
        sContext = context;
        LogFile.getInstance(context);
    }

    public static void leave() {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, "<====" + methodName);
    }

    public static void w(String str, String str2) {
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_I) {
            return;
        }
        if (mIsWriteToFile) {
            LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + "\n").getBytes());
            return;
        }
        String str3 = TAG;
        Log.w(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_E) {
            return;
        }
        if (mIsWriteToFile) {
            LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + "\n").getBytes());
            return;
        }
        String str3 = TAG;
        Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
    }

    public static void enter(String str) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, str + "====>" + methodName);
    }

    public static void leave(String str) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        if (!Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, str + "<====" + methodName);
    }
}
