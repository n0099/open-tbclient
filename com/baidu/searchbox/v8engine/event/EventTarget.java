package com.baidu.searchbox.v8engine.event;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes20.dex */
public interface EventTarget {
    @JavascriptInterface
    void addEventListener(String str, JsFunction jsFunction);

    @JavascriptInterface
    boolean dispatchEvent(JsObject jsObject);

    boolean dispatchEvent(JSEvent jSEvent);

    boolean hasEventListener(String... strArr);

    @JavascriptInterface
    void removeEventListener(String str);

    @JavascriptInterface
    void removeEventListener(String str, JsFunction jsFunction);
}
