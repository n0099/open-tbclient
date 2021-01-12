package com.baidu.swan.games.r;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public class d {
    private c ecB;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.ecB = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.ecB.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.ecB.setUserCloudStorage(jsObject);
    }
}
