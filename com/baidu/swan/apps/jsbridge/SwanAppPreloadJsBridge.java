package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.k63;
import com.baidu.tieba.k82;
import com.baidu.tieba.wp1;
@Keep
/* loaded from: classes3.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = wp1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public k82 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return k63.f();
    }

    public SwanAppPreloadJsBridge(k82 k82Var) {
        this.mJSContainer = k82Var;
    }
}
