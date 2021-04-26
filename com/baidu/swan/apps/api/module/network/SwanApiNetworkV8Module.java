package com.baidu.swan.apps.api.module.network;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.h0.a.t.b.d;
import d.a.h0.a.t.c.h.b;
@Keep
/* loaded from: classes2.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public b requestApi;

    public SwanApiNetworkV8Module(@NonNull d.a.h0.a.t.b.b bVar) {
        this.requestApi = new b(bVar);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        if (d.f44021c) {
            Log.d("Api-Request", "request: jsObject");
        }
        d.a.h0.a.t.e.b J = this.requestApi.J(jsObject);
        return J == null ? "" : J.b();
    }
}
