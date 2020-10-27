package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.f.b dLd;
    private b dRQ;

    public a(com.baidu.swan.games.f.b bVar) {
        this.dLd = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aTW(), this.dLd).j(jsObject);
    }

    @NonNull
    private b aTW() {
        if (this.dRQ == null) {
            this.dRQ = new b();
        }
        return this.dRQ;
    }
}
