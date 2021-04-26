package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.a.h0.a.k;
import d.a.h0.g.k0.j.a;
@Keep
/* loaded from: classes3.dex */
public class GameWebViewJavascriptInterface {
    public static final boolean DEBUG = k.f43101a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";

    @JavascriptInterface
    public void closeGameWebView() {
        if (DEBUG) {
            Log.i(TAG, "closeGameWebView");
        }
        a H = a.H();
        if (H != null) {
            H.close();
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        if (DEBUG) {
            Log.i(TAG, "onGameLoadingFinish");
        }
        a H = a.H();
        if (H != null) {
            H.K();
        }
    }
}
