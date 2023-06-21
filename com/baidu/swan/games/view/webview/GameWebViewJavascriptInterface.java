package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.js1;
import com.baidu.tieba.xf4;
@Keep
/* loaded from: classes4.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = js1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        xf4 E = xf4.E();
        if (E != null) {
            E.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        xf4 E = xf4.E();
        if (E != null) {
            E.H();
        }
    }
}
