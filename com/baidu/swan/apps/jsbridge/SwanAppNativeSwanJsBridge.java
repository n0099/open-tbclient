package com.baidu.swan.apps.jsbridge;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.b;
@Keep
/* loaded from: classes2.dex */
public class SwanAppNativeSwanJsBridge {
    private static final boolean DEBUG = b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    private static final String TAG = "SwanAppNativeSwanJsBridge";

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.a.getEnvVariables();
    }
}
