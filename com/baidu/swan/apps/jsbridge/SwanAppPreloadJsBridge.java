package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.b83;
import com.baidu.tieba.ba2;
import com.baidu.tieba.nr1;
@Keep
/* loaded from: classes4.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = nr1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public ba2 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return b83.f();
    }

    public SwanAppPreloadJsBridge(ba2 ba2Var) {
        this.mJSContainer = ba2Var;
    }
}
