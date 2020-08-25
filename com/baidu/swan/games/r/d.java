package com.baidu.swan.games.r;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public class d {
    private c dqD;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.dqD = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.dqD.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.dqD.setUserCloudStorage(jsObject);
    }
}
