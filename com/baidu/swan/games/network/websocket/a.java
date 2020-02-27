package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cjZ;
    private b cqB;

    public a(com.baidu.swan.games.e.b bVar) {
        this.cjZ = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aoV(), this.cjZ).h(jsObject);
    }

    @NonNull
    private b aoV() {
        if (this.cqB == null) {
            this.cqB = new b();
        }
        return this.cqB;
    }
}
