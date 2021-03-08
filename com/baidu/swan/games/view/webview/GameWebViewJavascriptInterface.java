package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes8.dex */
public class GameWebViewJavascriptInterface {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    private static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        a baj = a.baj();
        if (baj != null) {
            baj.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        a baj = a.baj();
        if (baj != null) {
            baj.onGameLoadingFinish();
        }
    }
}
