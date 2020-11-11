package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.f.b dQV;
    private b dXI;

    public a(com.baidu.swan.games.f.b bVar) {
        this.dQV = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aWw(), this.dQV).j(jsObject);
    }

    @NonNull
    private b aWw() {
        if (this.dXI == null) {
            this.dXI = new b();
        }
        return this.dXI;
    }
}
