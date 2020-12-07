package com.baidu.swan.games.r;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes25.dex */
public class d {
    private c dYr;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.dYr = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.dYr.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.dYr.setUserCloudStorage(jsObject);
    }
}
