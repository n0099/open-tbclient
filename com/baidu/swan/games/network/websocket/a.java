package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cJh;
    private b cPK;

    public a(com.baidu.swan.games.e.b bVar) {
        this.cJh = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(axn(), this.cJh).h(jsObject);
    }

    @NonNull
    private b axn() {
        if (this.cPK == null) {
            this.cPK = new b();
        }
        return this.cPK;
    }
}
