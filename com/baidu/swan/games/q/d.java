package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes10.dex */
public class d {
    private c chS;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.chS = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.chS.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.chS.setUserCloudStorage(jsObject);
    }
}
