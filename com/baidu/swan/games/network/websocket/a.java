package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.swan.games.f.b dqC;
    private b dxs;

    public a(com.baidu.swan.games.f.b bVar) {
        this.dqC = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aPt(), this.dqC).j(jsObject);
    }

    @NonNull
    private b aPt() {
        if (this.dxs == null) {
            this.dxs = new b();
        }
        return this.dxs;
    }
}
