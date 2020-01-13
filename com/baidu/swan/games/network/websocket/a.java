package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.e.b cfV;
    private b cmz;

    public a(com.baidu.swan.games.e.b bVar) {
        this.cfV = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(amI(), this.cfV).h(jsObject);
    }

    @NonNull
    private b amI() {
        if (this.cmz == null) {
            this.cmz = new b();
        }
        return this.cmz;
    }
}
