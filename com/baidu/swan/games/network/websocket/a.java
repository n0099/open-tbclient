package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b bad;
    private b bey;

    public a(com.baidu.swan.games.e.b bVar) {
        this.bad = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(OG(), this.bad).g(jsObject);
    }

    @NonNull
    private b OG() {
        if (this.bey == null) {
            this.bey = new b();
        }
        return this.bey;
    }
}
