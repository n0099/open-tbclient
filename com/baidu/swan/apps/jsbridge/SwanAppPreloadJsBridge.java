package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.i33;
import com.baidu.tieba.i52;
import com.baidu.tieba.vm1;
@Keep
/* loaded from: classes4.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = vm1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public i52 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return i33.f();
    }

    public SwanAppPreloadJsBridge(i52 i52Var) {
        this.mJSContainer = i52Var;
    }
}
