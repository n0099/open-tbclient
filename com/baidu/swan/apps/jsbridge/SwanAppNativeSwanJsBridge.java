package com.baidu.swan.apps.jsbridge;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.aq.i;
import com.baidu.swan.apps.b;
@Keep
/* loaded from: classes7.dex */
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
        return DEBUG ? com.baidu.swan.apps.ae.a.a.apj() ? i.z(i, false) : "" : (i.awq() && com.baidu.swan.apps.t.a.ahm().SE()) ? i.z(i, false) : "";
    }
}
