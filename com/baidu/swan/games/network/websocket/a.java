package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b dox;
    private b dvn;

    public a(com.baidu.swan.games.f.b bVar) {
        this.dox = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aOI(), this.dox).j(jsObject);
    }

    @NonNull
    private b aOI() {
        if (this.dvn == null) {
            this.dvn = new b();
        }
        return this.dvn;
    }
}
