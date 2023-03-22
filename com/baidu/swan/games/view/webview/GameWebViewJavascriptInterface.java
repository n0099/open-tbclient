package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.do1;
import com.baidu.tieba.rb4;
@Keep
/* loaded from: classes3.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = do1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        rb4 E = rb4.E();
        if (E != null) {
            E.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        rb4 E = rb4.E();
        if (E != null) {
            E.H();
        }
    }
}
