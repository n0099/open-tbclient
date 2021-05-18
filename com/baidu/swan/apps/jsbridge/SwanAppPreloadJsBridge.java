package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.a.i0.a.h0.f.a;
import d.a.i0.a.k;
import d.a.i0.a.v1.c.f.b;
@Keep
/* loaded from: classes3.dex */
public class SwanAppPreloadJsBridge {
    public static final boolean DEBUG = k.f43025a;
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
        return b.f();
    }
}
