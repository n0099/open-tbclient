package com.baidu.swan.apps.api.module.network;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.l0.a.u.c.b;
import d.a.l0.a.u.c.d;
import d.a.l0.a.u.e.j.g;
@Keep
/* loaded from: classes2.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public g requestApi;

    public SwanApiNetworkV8Module(@NonNull b bVar) {
        this.requestApi = new g(bVar);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        if (d.f48486c) {
            Log.d("Api-Request", "request: jsObject");
        }
        d.a.l0.a.u.h.b L = this.requestApi.L(jsObject);
        return L == null ? "" : L.a();
    }
}
