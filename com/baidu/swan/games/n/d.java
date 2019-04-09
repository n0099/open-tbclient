package com.baidu.swan.games.n;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class d {
    private c bba;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.bba = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.bba.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.bba.setUserCloudStorage(jsObject);
    }
}
