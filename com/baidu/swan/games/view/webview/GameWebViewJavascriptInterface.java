package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.a.m0.a.k;
import d.a.m0.h.o0.h.a;
@Keep
/* loaded from: classes3.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = k.f46983a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        a G = a.G();
        if (G != null) {
            G.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        a G = a.G();
        if (G != null) {
            G.J();
        }
    }
}
