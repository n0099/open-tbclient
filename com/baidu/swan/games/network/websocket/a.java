package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.games.e.b cfI;
    private b cmm;

    public a(com.baidu.swan.games.e.b bVar) {
        this.cfI = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(amp(), this.cfI).h(jsObject);
    }

    @NonNull
    private b amp() {
        if (this.cmm == null) {
            this.cmm = new b();
        }
        return this.cmm;
    }
}
