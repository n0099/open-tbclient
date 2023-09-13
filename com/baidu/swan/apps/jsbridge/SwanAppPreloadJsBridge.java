package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.f83;
import com.baidu.tieba.fa2;
import com.baidu.tieba.rr1;
@Keep
/* loaded from: classes4.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = rr1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public fa2 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return f83.f();
    }

    public SwanAppPreloadJsBridge(fa2 fa2Var) {
        this.mJSContainer = fa2Var;
    }
}
