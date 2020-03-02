package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cka;
    private b cqC;

    public a(com.baidu.swan.games.e.b bVar) {
        this.cka = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aoX(), this.cka).h(jsObject);
    }

    @NonNull
    private b aoX() {
        if (this.cqC == null) {
            this.cqC = new b();
        }
        return this.cqC;
    }
}
