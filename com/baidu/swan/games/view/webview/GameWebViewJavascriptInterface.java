package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.ff4;
import com.baidu.tieba.rr1;
@Keep
/* loaded from: classes4.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = rr1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        ff4 D = ff4.D();
        if (D != null) {
            D.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        ff4 D = ff4.D();
        if (D != null) {
            D.G();
        }
    }
}
