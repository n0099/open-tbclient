package com.baidu.swan.games.network.websocket;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b eaw;
    private b ehk;

    public a(com.baidu.swan.games.f.b bVar) {
        this.eaw = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aXu(), this.eaw).j(jsObject);
    }

    @NonNull
    private b aXu() {
        if (this.ehk == null) {
            this.ehk = new b();
        }
        return this.ehk;
    }
}
