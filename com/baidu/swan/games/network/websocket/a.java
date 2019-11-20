package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private b bBW;
    private com.baidu.swan.games.e.b bxv;

    public a(com.baidu.swan.games.e.b bVar) {
        this.bxv = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(Xx(), this.bxv).h(jsObject);
    }

    @NonNull
    private b Xx() {
        if (this.bBW == null) {
            this.bBW = new b();
        }
        return this.bBW;
    }
}
