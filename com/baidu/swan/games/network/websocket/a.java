package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes25.dex */
public class a {
    private com.baidu.swan.games.f.b dWl;
    private b ecZ;

    public a(com.baidu.swan.games.f.b bVar) {
        this.dWl = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aYT(), this.dWl).j(jsObject);
    }

    @NonNull
    private b aYT() {
        if (this.ecZ == null) {
            this.ecZ = new b();
        }
        return this.ecZ;
    }
}
