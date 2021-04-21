package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.b.h0.a.e0.k.a;
import d.b.h0.a.k;
import d.b.h0.a.n1.c.f.b;
@Keep
/* loaded from: classes2.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = k.f45772a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public a mJSContainer;

    public SwanAppPreloadJsBridge(a aVar) {
        this.mJSContainer = aVar;
    }

    @JavascriptInterface
    public String onJSLoaded() {
        this.mJSContainer.onJSLoaded();
        if (DEBUG) {
            Log.d(TAG, "onJsLoaded");
        }
        return b.d();
    }
}
