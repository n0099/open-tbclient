package com.baidu.swan.apps.console;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.e;
/* loaded from: classes2.dex */
public class c {
    private static boolean amO = false;

    public static void aR(boolean z) {
        amO = z;
    }

    public static boolean wK() {
        return amO;
    }

    public static void d(String str, String str2) {
        j("debug", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        j("info", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        j("warn", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        j("error", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        j("error", str, th != null ? "Exception:" + th.getMessage() + "\n" + str2 : str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2, th);
        }
    }

    private static void j(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && amO) {
            StringBuilder sb = new StringBuilder();
            String a = e.a(e.LO(), "yyyy-MM-dd HH:mm:ss");
            String fileName = getFileName();
            sb.append(a).append("  ").append(fileName).append("  ").append("line:").append(getLineNumber()).append("\n").append("module:").append(str2).append("\n").append(str3);
            com.baidu.swan.apps.w.e.Ea().DG().W(str, sb.toString());
        }
    }

    private static String getFileName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return (stackTrace == null || stackTrace.length <= 5) ? AppRuntime.getAppContext().getString(a.h.aiapps_err_message_get_name_fail) : stackTrace[5].getFileName();
    }

    private static int getLineNumber() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 5) {
            return -1;
        }
        return stackTrace[5].getLineNumber();
    }
}
