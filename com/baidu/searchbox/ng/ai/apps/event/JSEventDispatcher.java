package com.baidu.searchbox.ng.ai.apps.event;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceTrace;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class JSEventDispatcher {
    private static final boolean DEBUG = false;
    public static final int DOCUMENT_TYPE_EVENT = 1;
    private static final String TAG = "JSEventDispatcher";
    public static final int WINDOW_TYPE_EVENT = 0;

    public static void dispatchJSEvent(final BdSailorWebView bdSailorWebView, AiAppsBaseMessage aiAppsBaseMessage, int i) {
        if (bdSailorWebView != null && aiAppsBaseMessage != null) {
            AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "dispatchJSEvent start.");
            final String format = String.format(Locale.getDefault(), "javascript:(function(){%s %s %s})();", String.format(Locale.getDefault(), "var %s = new Event('%s');", NotificationCompat.CATEGORY_EVENT, aiAppsBaseMessage.mEventName), aiAppsBaseMessage.genSetDataStatement(NotificationCompat.CATEGORY_EVENT), String.format(Locale.getDefault(), "%s.dispatchEvent(%s);", getDispatchJSObject(i), NotificationCompat.CATEGORY_EVENT));
            AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "dispatchJSEvent buildEvent");
            AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.event.JSEventDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BdSailorWebView.this.isDestroyed()) {
                        Log.e(JSEventDispatcher.TAG, Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + format)));
                        return;
                    }
                    BdSailorWebView.this.evaluateJavascript(format, null);
                    AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "dispatchJSEvent evaluateJavascript");
                }
            });
        }
    }

    private static String getDispatchJSObject(int i) {
        switch (i) {
            case 0:
                return WindowConfig.JSON_WINDOW_KEY;
            case 1:
                return "document";
            default:
                return WindowConfig.JSON_WINDOW_KEY;
        }
    }

    public static String genJSVarKeyValue(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        return String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, JSONObject.quote(str3));
    }

    public static String genJSVarKeyValue(String str, String str2, JSONObject jSONObject) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) ? "" : String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, jSONObject);
    }
}
