package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b ckb;
    private b cqD;

    public a(com.baidu.swan.games.e.b bVar) {
        this.ckb = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aoX(), this.ckb).h(jsObject);
    }

    @NonNull
    private b aoX() {
        if (this.cqD == null) {
            this.cqD = new b();
        }
        return this.cqD;
    }
}
