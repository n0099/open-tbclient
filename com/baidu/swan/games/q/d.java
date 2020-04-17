package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class d {
    private c cLg;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.cLg = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.cLg.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.cLg.setUserCloudStorage(jsObject);
    }
}
