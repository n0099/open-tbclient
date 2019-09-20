package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b bft;
    private b bjZ;

    public a(com.baidu.swan.games.e.b bVar) {
        this.bft = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(SI(), this.bft).h(jsObject);
    }

    @NonNull
    private b SI() {
        if (this.bjZ == null) {
            this.bjZ = new b();
        }
        return this.bjZ;
    }
}
