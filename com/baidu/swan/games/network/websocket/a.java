package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b ckm;
    private b cqO;

    public a(com.baidu.swan.games.e.b bVar) {
        this.ckm = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(apa(), this.ckm).h(jsObject);
    }

    @NonNull
    private b apa() {
        if (this.cqO == null) {
            this.cqO = new b();
        }
        return this.cqO;
    }
}
