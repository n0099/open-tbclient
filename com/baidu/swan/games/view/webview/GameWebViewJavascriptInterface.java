package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.ag4;
import com.baidu.tieba.ms1;
@Keep
/* loaded from: classes4.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = ms1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        ag4 E = ag4.E();
        if (E != null) {
            E.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        ag4 E = ag4.E();
        if (E != null) {
            E.H();
        }
    }
}
