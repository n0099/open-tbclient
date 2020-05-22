package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.f.b cTU;
    private b daM;

    public a(com.baidu.swan.games.f.b bVar) {
        this.cTU = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aBe(), this.cTU).j(jsObject);
    }

    @NonNull
    private b aBe() {
        if (this.daM == null) {
            this.daM = new b();
        }
        return this.daM;
    }
}
