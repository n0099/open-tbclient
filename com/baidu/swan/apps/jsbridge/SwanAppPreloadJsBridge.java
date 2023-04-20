package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.fo1;
import com.baidu.tieba.t43;
import com.baidu.tieba.t62;
@Keep
/* loaded from: classes3.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = fo1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public t62 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return t43.f();
    }

    public SwanAppPreloadJsBridge(t62 t62Var) {
        this.mJSContainer = t62Var;
    }
}
