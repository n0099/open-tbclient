package com.baidu.swan.games.r;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes9.dex */
public class d {
    private c eho;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.eho = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.eho.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.eho.setUserCloudStorage(jsObject);
    }
}
