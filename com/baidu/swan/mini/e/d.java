package com.baidu.swan.mini.e;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean c(@Nullable com.baidu.swan.apps.core.container.a aVar, @Nullable String str) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (aVar.isWebView()) {
            String str2 = "javascript:(function(){var event = new Event('mini'); event.message = '" + b.pU(str) + "'; window.___NA_SWAN_MINI___.dispatchEvent(event);})();";
            aVar.evaluateJavascript(str2, null);
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message js : " + str2);
            }
        } else {
            String str3 = "javascript:(function(){var event = new Object(); event.type = 'mini';event.message = '" + b.pU(str) + "'; _naSwan.dispatchEvent(event);})();";
            aVar.evaluateJavascript(str3, null);
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message js : " + str3);
            }
        }
        return true;
    }

    public static boolean a(@Nullable com.baidu.swan.apps.core.container.a aVar, @Nullable String str, @Nullable String str2) {
        if (aVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (aVar.isWebView()) {
            String str3 = "(function() {'use strict';(function() {" + ("var event = new Event('mini'); event.appInstanceId = '" + b.pU(str) + "'; event.message = '" + b.pU(str2) + "'; window.___NA_SWAN_MINI___.dispatchEvent(event);") + "}).call();})();";
            aVar.evaluateJavascript(str3, null);
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message js : " + str3);
            }
        } else {
            String str4 = "var event = new Object(); event.appInstanceId = '" + b.pU(str) + "'; event.type = 'mini'; event.message = '" + b.pU(str2) + "'; _naSwan.dispatchEvent(event);";
            aVar.evaluateJavascript(str4, null);
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message js : " + str4);
            }
        }
        return true;
    }
}
