package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
public class a {
    private b bCN;
    private com.baidu.swan.games.e.b bym;

    public a(com.baidu.swan.games.e.b bVar) {
        this.bym = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(Xz(), this.bym).h(jsObject);
    }

    @NonNull
    private b Xz() {
        if (this.bCN == null) {
            this.bCN = new b();
        }
        return this.bCN;
    }
}
