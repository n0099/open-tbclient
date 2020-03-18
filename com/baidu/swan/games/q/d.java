package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class d {
    private c cmk;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.cmk = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.cmk.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.cmk.setUserCloudStorage(jsObject);
    }
}
