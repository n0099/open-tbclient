package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.am1;
import com.baidu.tieba.n94;
@Keep
/* loaded from: classes4.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = am1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        n94 D = n94.D();
        if (D != null) {
            D.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        n94 D = n94.D();
        if (D != null) {
            D.G();
        }
    }
}
