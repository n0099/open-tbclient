package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b bac;
    private b bex;

    public a(com.baidu.swan.games.e.b bVar) {
        this.bac = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(OG(), this.bac).g(jsObject);
    }

    @NonNull
    private b OG() {
        if (this.bex == null) {
            this.bex = new b();
        }
        return this.bex;
    }
}
