package com.baidu.searchbox.ng.ai.apps.console;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class AiAppsLog {
    private static final String CONSOLE_WEBVIEW_ID = "console";
    private static final String DEBUG = "debug";
    private static final String ERROR = "error";
    private static final String EVENT_NAME = "searchboxSConsole";
    private static final String INFO = "info";
    private static final String KEY_EVENT_DATA = "logs";
    private static final String KEY_EVENT_TYPE = "logType";
    private static final String LOG = "log";
    private static final int STACK_TRACE_INDEX = 5;
    private static final String TAG = "AiAppsLog";
    private static final String WARN = "warn";
    private static boolean sLogSwitch = false;

    private AiAppsLog() {
    }

    public static void setConsoleSwitch(boolean z) {
        sLogSwitch = z;
    }

    public static boolean getConsoleSwitch() {
        return sLogSwitch;
    }

    public static void v(String str, String str2) {
        print("log", str, str2);
    }

    public static void d(String str, String str2) {
        print("debug", str, str2);
    }

    public static void i(String str, String str2) {
        print("info", str, str2);
    }

    public static void w(String str, String str2) {
        print(WARN, str, str2);
    }

    public static void e(String str, String str2) {
        print("error", str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (th != null) {
            str2 = "Exception:" + th.getMessage() + "\n" + str2;
        }
        print("error", str, str2);
    }

    private static void print(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && sLogSwitch) {
            StringBuilder sb = new StringBuilder();
            String formatDate = AiAppDateTimeUtil.getFormatDate(AiAppDateTimeUtil.getCurrDate(), AiAppDateTimeUtil.TIME_FORMAT);
            sb.append(formatDate).append("  ").append(getFileName()).append("  ").append("line:").append(getLineNumber()).append("\n").append("module:").append(str2).append("\n").append(str3);
            print(str, new String[]{sb.toString()});
        }
    }

    private static void print(String str, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2)) {
                    jSONArray.put(str2);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(KEY_EVENT_TYPE, str);
            hashMap.put(KEY_EVENT_DATA, jSONArray.toString());
            AiAppsController.getInstance().sendJSMessage(CONSOLE_WEBVIEW_ID, new AiAppsCommonMessage(EVENT_NAME, hashMap));
        }
    }

    private static String getFileName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return (stackTrace == null || stackTrace.length <= 5) ? AppRuntime.getAppContext().getString(R.string.aiapps_err_message_get_name_fail) : stackTrace[5].getFileName();
    }

    private static int getLineNumber() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 5) {
            return -1;
        }
        return stackTrace[5].getLineNumber();
    }
}
