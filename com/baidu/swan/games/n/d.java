package com.baidu.swan.games.n;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class d {
    private c baW;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.baW = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.baW.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.baW.setUserCloudStorage(jsObject);
    }
}
