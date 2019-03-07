package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b aZY;
    private b bes;

    public a(com.baidu.swan.games.e.b bVar) {
        this.aZY = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(OI(), this.aZY).g(jsObject);
    }

    @NonNull
    private b OI() {
        if (this.bes == null) {
            this.bes = new b();
        }
        return this.bes;
    }
}
