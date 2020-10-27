package com.baidu.swan.games.r;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes10.dex */
public class d {
    private c dNj;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.dNj = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.dNj.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.dNj.setUserCloudStorage(jsObject);
    }
}
