package com.baidu.swan.apps.console;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.h;
import com.baidu.swan.apps.y.f;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class c {
    private static boolean bfv = false;

    public static void bZ(boolean z) {
        bfv = z;
    }

    public static boolean Jd() {
        return bfv;
    }

    public static void v(String str, String str2) {
        o(TbConfig.TMP_LOG_DIR_NAME, str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        o("debug", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        o("info", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        o("warn", str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        o(BdStatsConstant.StatsType.ERROR, str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        o(BdStatsConstant.StatsType.ERROR, str, th != null ? "Exception:" + th.getMessage() + "\n" + str2 : str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2, th);
        }
    }

    private static void o(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && bfv) {
            StringBuilder sb = new StringBuilder();
            String formatDate = h.getFormatDate(h.getCurrDate(), DateTimeUtil.TIME_FORMAT);
            String fileName = getFileName();
            sb.append(formatDate).append("  ").append(fileName).append("  ").append("line:").append(getLineNumber()).append("\n").append("module:").append(str2).append("\n").append(str3);
            f.UC().Ug().ag(str, sb.toString());
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
