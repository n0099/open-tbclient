package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b beh;
    private b biO;

    public a(com.baidu.swan.games.e.b bVar) {
        this.beh = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(RL(), this.beh).h(jsObject);
    }

    @NonNull
    private b RL() {
        if (this.biO == null) {
            this.biO = new b();
        }
        return this.biO;
    }
}
