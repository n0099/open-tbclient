package com.baidu.swan.games.o;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class d {
    private c bfJ;

    public d(@NonNull com.baidu.swan.games.e.a aVar) {
        this.bfJ = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.bfJ.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.bfJ.setUserCloudStorage(jsObject);
    }
}
