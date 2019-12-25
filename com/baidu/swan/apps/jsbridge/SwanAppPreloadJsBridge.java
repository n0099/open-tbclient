package com.baidu.swan.apps.jsbridge;

import android.support.annotation.Keep;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.b;
@Keep
/* loaded from: classes9.dex */
public class SwanAppPreloadJsBridge {
    private static final boolean DEBUG = b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    private static final String TAG = "SwanAppPreloadJsBridge";
    private com.baidu.swan.apps.core.container.a mJSContainer;

    public SwanAppPreloadJsBridge(com.baidu.swan.apps.core.container.a aVar) {
        this.mJSContainer = aVar;
    }

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return com.baidu.swan.apps.process.messaging.service.b.Yt();
    }
}
