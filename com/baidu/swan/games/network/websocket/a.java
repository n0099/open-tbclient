package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b doB;
    private b dvr;

    public a(com.baidu.swan.games.f.b bVar) {
        this.doB = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aOI(), this.doB).j(jsObject);
    }

    @NonNull
    private b aOI() {
        if (this.dvr == null) {
            this.dvr = new b();
        }
        return this.dvr;
    }
}
