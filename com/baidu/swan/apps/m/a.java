package com.baidu.swan.apps.m;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.performance.e;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void a(final com.baidu.swan.apps.core.container.a aVar, com.baidu.swan.apps.m.a.a aVar2) {
        String format;
        String n;
        if (aVar != null && aVar2 != null) {
            e.as("postMessage", "dispatchJSEvent start.");
            if (aVar.xR()) {
                format = String.format(Locale.getDefault(), "var %s = new Event('%s');", NotificationCompat.CATEGORY_EVENT, aVar2.avn);
                n = "";
            } else {
                format = String.format(Locale.getDefault(), "var %s = new Object();", NotificationCompat.CATEGORY_EVENT);
                n = n(NotificationCompat.CATEGORY_EVENT, "type", aVar2.avn);
            }
            final String format2 = String.format(Locale.getDefault(), "javascript:(function(){%s %s %s})();", format, n + aVar2.eC(NotificationCompat.CATEGORY_EVENT), String.format(Locale.getDefault(), "%s.dispatchEvent(%s);", a(aVar), NotificationCompat.CATEGORY_EVENT));
            e.as("postMessage", "dispatchJSEvent buildEvent");
            if (DEBUG) {
                Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format2);
            }
            if (aVar.xR()) {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.m.a.1
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
            Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
            return;
        }
        aVar.evaluateJavascript(str, null);
        e.as("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    private static String a(com.baidu.swan.apps.core.container.a aVar) {
        if (aVar.xR()) {
            return "document";
        }
        return SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME;
    }

    public static String n(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        return String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, JSONObject.quote(str3));
    }

    public static String b(String str, String str2, JSONObject jSONObject) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) ? "" : String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, jSONObject);
    }
}
