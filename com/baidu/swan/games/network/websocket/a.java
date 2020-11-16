package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes7.dex */
public class a {
    private com.baidu.swan.games.f.b dPn;
    private b dWa;

    public a(com.baidu.swan.games.f.b bVar) {
        this.dPn = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aVO(), this.dPn).j(jsObject);
    }

    @NonNull
    private b aVO() {
        if (this.dWa == null) {
            this.dWa = new b();
        }
        return this.dWa;
    }
}
