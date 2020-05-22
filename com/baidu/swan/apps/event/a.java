package com.baidu.swan.apps.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.performance.f;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void a(final com.baidu.swan.apps.core.container.a aVar, com.baidu.swan.apps.event.a.a aVar2) {
        String format;
        String x;
        if (aVar != null && aVar2 != null) {
            f.D("postMessage", "dispatchJSEvent start.");
            if (aVar.isWebView()) {
                format = String.format(Locale.getDefault(), "var %s = new Event('%s');", NotificationCompat.CATEGORY_EVENT, aVar2.bMG);
                x = "";
            } else {
                format = String.format(Locale.getDefault(), "var %s = new Object();", NotificationCompat.CATEGORY_EVENT);
                x = x(NotificationCompat.CATEGORY_EVENT, "type", aVar2.bMG);
            }
            final String format2 = String.format(Locale.getDefault(), "javascript:(function(){%s %s %s})();", format, x + aVar2.kd(NotificationCompat.CATEGORY_EVENT), String.format(Locale.getDefault(), "%s.dispatchEvent(%s);", d(aVar), NotificationCompat.CATEGORY_EVENT));
            f.D("postMessage", "dispatchJSEvent buildEvent");
            if (DEBUG) {
                Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format2);
            }
            if (aVar.isWebView()) {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.event.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.a(com.baidu.swan.apps.core.container.a.this, format2);
                    }
                });
            } else {
                a(aVar, format2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.swan.apps.core.container.a aVar, String str) {
        if (aVar.isDestroyed()) {
            if (DEBUG) {
                Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                return;
            }
            return;
        }
        aVar.evaluateJavascript(str, null);
        f.D("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    private static String d(com.baidu.swan.apps.core.container.a aVar) {
        if (aVar.isWebView()) {
            return "document";
        }
        return SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME;
    }

    public static String x(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        return String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, JSONObject.quote(str3));
    }

    public static String c(String str, String str2, JSONObject jSONObject) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) ? "" : String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, jSONObject);
    }

    @NonNull
    public static String c(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || obj == null) {
            return "";
        }
        return ((obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Boolean)) ? String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, obj) : x(str, str2, String.valueOf(obj));
    }
}
