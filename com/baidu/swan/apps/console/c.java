package com.baidu.swan.apps.console;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.e;
/* loaded from: classes2.dex */
public class c {
    private static boolean aHt = false;

    public static void bo(boolean z) {
        aHt = z;
    }

    public static boolean Df() {
        return aHt;
    }

    public static void d(String str, String str2) {
        n("debug", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        n(Config.LAUNCH_INFO, str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        n("warn", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        n(BdStatsConstant.StatsType.ERROR, str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        n(BdStatsConstant.StatsType.ERROR, str, th != null ? "Exception:" + th.getMessage() + "\n" + str2 : str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2, th);
        }
    }

    private static void n(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && aHt) {
            StringBuilder sb = new StringBuilder();
            String a = e.a(e.Ue(), "yyyy-MM-dd HH:mm:ss");
            String fileName = getFileName();
            sb.append(a).append("  ").append(fileName).append("  ").append("line:").append(Dg()).append("\n").append("module:").append(str2).append("\n").append(str3);
            com.baidu.swan.apps.w.e.LD().Lj().Y(str, sb.toString());
        }
    }

    private static String getFileName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return (stackTrace == null || stackTrace.length <= 5) ? AppRuntime.getAppContext().getString(a.h.aiapps_err_message_get_name_fail) : stackTrace[5].getFileName();
    }

    private static int Dg() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 5) {
            return -1;
        }
        return stackTrace[5].getLineNumber();
    }
}
