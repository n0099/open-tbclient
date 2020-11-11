package com.baidu.swan.apps.jsbridge;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
@Keep
/* loaded from: classes10.dex */
public class SwanAppNativeSwanJsBridge {
    private static final boolean DEBUG = b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    private static final String TAG = "SwanAppNativeSwanJsBridge";
    private com.baidu.swan.apps.core.container.a mJSContainer;

    public SwanAppNativeSwanJsBridge(com.baidu.swan.apps.core.container.a aVar) {
        this.mJSContainer = aVar;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.mJSContainer);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aET() ? i.C(i, false) : "";
        } else if (!i.aMn()) {
            return "";
        } else {
            return i.C(i, false);
        }
    }
}
