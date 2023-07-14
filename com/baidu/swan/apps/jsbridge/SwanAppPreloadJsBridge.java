package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.fs1;
import com.baidu.tieba.t83;
import com.baidu.tieba.ta2;
@Keep
/* loaded from: classes4.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = fs1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public ta2 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return t83.f();
    }

    public SwanAppPreloadJsBridge(ta2 ta2Var) {
        this.mJSContainer = ta2Var;
    }
}
