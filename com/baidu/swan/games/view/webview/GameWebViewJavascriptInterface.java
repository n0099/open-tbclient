package com.baidu.swan.games.view.webview;

import android.support.annotation.Keep;
import android.util.Log;
import android.webkit.JavascriptInterface;
@Keep
/* loaded from: classes11.dex */
public class GameWebViewJavascriptInterface {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    private static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        a arm = a.arm();
        if (arm != null) {
            arm.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        a arm = a.arm();
        if (arm != null) {
            arm.onGameLoadingFinish();
        }
    }
}
