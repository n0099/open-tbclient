package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.do1;
import com.baidu.tieba.r43;
import com.baidu.tieba.r62;
@Keep
/* loaded from: classes3.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = do1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public r62 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return r43.f();
    }

    public SwanAppPreloadJsBridge(r62 r62Var) {
        this.mJSContainer = r62Var;
    }
}
