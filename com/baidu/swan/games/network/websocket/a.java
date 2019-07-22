package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b beU;
    private b bjB;

    public a(com.baidu.swan.games.e.b bVar) {
        this.beU = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(SE(), this.beU).h(jsObject);
    }

    @NonNull
    private b SE() {
        if (this.bjB == null) {
            this.bjB = new b();
        }
        return this.bjB;
    }
}
