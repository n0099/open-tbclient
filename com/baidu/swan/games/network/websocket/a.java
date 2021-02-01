package com.baidu.swan.games.network.websocket;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.games.f.b ecD;
    private b ejr;

    public a(com.baidu.swan.games.f.b bVar) {
        this.ecD = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aXG(), this.ecD).j(jsObject);
    }

    @NonNull
    private b aXG() {
        if (this.ejr == null) {
            this.ejr = new b();
        }
        return this.ejr;
    }
}
