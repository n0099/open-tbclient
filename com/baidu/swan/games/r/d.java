package com.baidu.swan.games.r;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes9.dex */
public class d {
    private c eeI;

    public d(@NonNull com.baidu.swan.games.f.a aVar) {
        this.eeI = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.eeI.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.eeI.setUserCloudStorage(jsObject);
    }
}
