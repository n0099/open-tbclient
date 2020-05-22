package com.baidu.swan.apps.jsbridge;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.aq.h;
import com.baidu.swan.apps.b;
@Keep
/* loaded from: classes11.dex */
public class SwanAppNativeSwanJsBridge {
    private static final boolean DEBUG = b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    private static final String TAG = "SwanAppNativeSwanJsBridge";

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.af.a.a.amt() ? h.z(i, false) : "" : (h.ati() && com.baidu.swan.apps.u.a.aeU().Rh()) ? h.z(i, false) : "";
    }
}
