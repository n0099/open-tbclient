package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b aZZ;
    private b beu;

    public a(com.baidu.swan.games.e.b bVar) {
        this.aZZ = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(OI(), this.aZZ).g(jsObject);
    }

    @NonNull
    private b OI() {
        if (this.beu == null) {
            this.beu = new b();
        }
        return this.beu;
    }
}
