package com.baidu.swan.games.r;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class d {
    private c daL;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.daL = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.daL.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.daL.setUserCloudStorage(jsObject);
    }
}
