package com.baidu.swan.games.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public interface b {
    @JavascriptInterface
    void destroy();

    @JavascriptInterface
    void hide();

    @JavascriptInterface
    void showAd(JsObject jsObject);
}
