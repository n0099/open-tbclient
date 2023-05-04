package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.ho1;
import com.baidu.tieba.v43;
import com.baidu.tieba.v62;
@Keep
/* loaded from: classes3.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = ho1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public v62 mJSContainer;

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return v43.f();
    }

    public SwanAppPreloadJsBridge(v62 v62Var) {
        this.mJSContainer = v62Var;
    }
}
