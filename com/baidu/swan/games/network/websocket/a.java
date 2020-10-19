package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.f.b dCG;
    private b dJt;

    public a(com.baidu.swan.games.f.b bVar) {
        this.dCG = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aSc(), this.dCG).j(jsObject);
    }

    @NonNull
    private b aSc() {
        if (this.dJt == null) {
            this.dJt = new b();
        }
        return this.dJt;
    }
}
