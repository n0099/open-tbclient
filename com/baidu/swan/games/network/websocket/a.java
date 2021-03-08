package com.baidu.swan.games.network.websocket;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b eee;
    private b ekS;

    public a(com.baidu.swan.games.f.b bVar) {
        this.eee = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aXJ(), this.eee).j(jsObject);
    }

    @NonNull
    private b aXJ() {
        if (this.ekS == null) {
            this.ekS = new b();
        }
        return this.ekS;
    }
}
