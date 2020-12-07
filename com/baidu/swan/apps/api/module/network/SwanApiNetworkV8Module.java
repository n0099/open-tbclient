package com.baidu.swan.apps.api.module.network;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
@Keep
/* loaded from: classes25.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    private b requestApi;

    public SwanApiNetworkV8Module(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        this.requestApi = new b(bVar);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        if (b.DEBUG) {
            Log.d("Api-Request", "request: jsObject");
        }
        com.baidu.swan.apps.api.c.b b = this.requestApi.b(jsObject);
        return b == null ? "" : b.toJsonString();
    }
}
