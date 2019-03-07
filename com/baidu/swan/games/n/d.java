package com.baidu.swan.games.n;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class d {
    private c baV;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.baV = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.baV.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.baV.setUserCloudStorage(jsObject);
    }
}
