package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.f.b cYE;
    private b dfz;

    public a(com.baidu.swan.games.f.b bVar) {
        this.cYE = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aCk(), this.cYE).j(jsObject);
    }

    @NonNull
    private b aCk() {
        if (this.dfz == null) {
            this.dfz = new b();
        }
        return this.dfz;
    }
}
