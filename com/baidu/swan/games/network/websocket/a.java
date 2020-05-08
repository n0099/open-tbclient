package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cJn;
    private b cPP;

    public a(com.baidu.swan.games.e.b bVar) {
        this.cJn = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(axn(), this.cJn).h(jsObject);
    }

    @NonNull
    private b axn() {
        if (this.cPP == null) {
            this.cPP = new b();
        }
        return this.cPP;
    }
}
