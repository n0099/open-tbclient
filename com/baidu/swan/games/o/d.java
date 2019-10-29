package com.baidu.swan.games.o;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class d {
    private c bza;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.bza = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.bza.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.bza.setUserCloudStorage(jsObject);
    }
}
