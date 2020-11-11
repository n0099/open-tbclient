package com.baidu.swan.games.r;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes10.dex */
public class d {
    private c dTb;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.dTb = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.dTb.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.dTb.setUserCloudStorage(jsObject);
    }
}
