package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class d {
    private c clY;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.clY = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.clY.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.clY.setUserCloudStorage(jsObject);
    }
}
