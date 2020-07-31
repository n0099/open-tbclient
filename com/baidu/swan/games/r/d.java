package com.baidu.swan.games.r;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes7.dex */
public class d {
    private c dgu;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.dgu = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.dgu.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.dgu.setUserCloudStorage(jsObject);
    }
}
