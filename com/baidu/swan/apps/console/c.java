package com.baidu.swan.apps.console;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.j;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public class c {
    private static boolean bWG = false;

    public static void dz(boolean z) {
        bWG = z;
    }

    public static boolean XD() {
        return bWG;
    }

    public static void d(String str, String str2) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2, Object obj) {
        if (com.baidu.swan.apps.b.DEBUG) {
            if (obj != null) {
                str2 = str2 + obj;
            }
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        t("info", str, str2);
        com.baidu.swan.apps.t.a.aij().i(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        t("warn", str, str2);
        com.baidu.swan.apps.t.a.aij().w(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        t(BdStatsConstant.StatsType.ERROR, str, str2);
        com.baidu.swan.apps.t.a.aij().e(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        t(BdStatsConstant.StatsType.ERROR, str, th != null ? "Exception:" + th.getMessage() + "\n" + str2 : str2);
        com.baidu.swan.apps.t.a.aij().e(str, str2, th);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2, th);
        }
    }

    public static void aW(String str, String str2) {
        com.baidu.swan.apps.t.a.aij().i(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        com.baidu.swan.apps.t.a.aij().e(str, str2, th);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2, th);
        }
    }

    private static void t(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && bWG) {
            StringBuilder sb = new StringBuilder();
            String a = j.a(j.awy(), "yyyy-MM-dd HH:mm:ss");
            String fileName = getFileName();
            sb.append(a).append("  ").append(fileName).append("  ").append("line:").append(getLineNumber()).append("\n").append("module:").append(str2).append("\n").append(str3);
            f.akr().ajU().aQ(str, sb.toString());
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
