package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.am1;
import com.baidu.tieba.n23;
import com.baidu.tieba.n42;
@Keep
/* loaded from: classes4.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = am1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public n42 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return n23.f();
    }

    public SwanAppPreloadJsBridge(n42 n42Var) {
        this.mJSContainer = n42Var;
    }
}
