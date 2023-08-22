package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.bf4;
import com.baidu.tieba.nr1;
@Keep
/* loaded from: classes4.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = nr1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        bf4 D = bf4.D();
        if (D != null) {
            D.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        bf4 D = bf4.D();
        if (D != null) {
            D.G();
        }
    }
}
