package com.baidu.swan.games.r;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public class d {
    private c egj;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.egj = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.egj.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.egj.setUserCloudStorage(jsObject);
    }
}
