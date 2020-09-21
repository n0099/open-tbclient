package com.baidu.swan.apps.console;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.j;
import com.baidu.swan.apps.v.f;
/* loaded from: classes3.dex */
public class c {
    private static boolean cev = false;

    public static void dH(boolean z) {
        cev = z;
    }

    public static boolean aet() {
        return cev;
    }

    public static void d(String str, Object... objArr) {
        if (com.baidu.swan.apps.b.DEBUG && objArr != null) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            Log.d(str, sb.toString());
        }
    }

    public static void i(String str, String str2) {
        u("info", str, str2);
        com.baidu.swan.apps.t.a.aqv().i(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        u("warn", str, str2);
        com.baidu.swan.apps.t.a.aqv().w(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        u(BdStatsConstant.StatsType.ERROR, str, str2);
        com.baidu.swan.apps.t.a.aqv().e(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        u(BdStatsConstant.StatsType.ERROR, str, th != null ? "Exception:" + th.getMessage() + "\n" + str2 : str2);
        com.baidu.swan.apps.t.a.aqv().e(str, str2, th);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2, th);
        }
    }

    public static void bb(String str, String str2) {
        com.baidu.swan.apps.t.a.aqv().i(str, str2);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        com.baidu.swan.apps.t.a.aqv().e(str, str2, th);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e(str, str2, th);
        }
    }

    private static void u(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && cev) {
            StringBuilder sb = new StringBuilder();
            String a = j.a(j.aFs(), "yyyy-MM-dd HH:mm:ss");
            String fileName = getFileName();
            sb.append(a).append("  ").append(fileName).append("  ").append("line:").append(getLineNumber()).append("\n").append("module:").append(str2).append("\n").append(str3);
            f.asJ().asl().aU(str, sb.toString());
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
