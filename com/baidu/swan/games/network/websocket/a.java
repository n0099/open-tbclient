package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes7.dex */
public class a {
    private com.baidu.swan.games.f.b deo;
    private b dli;

    public a(com.baidu.swan.games.f.b bVar) {
        this.deo = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(aFR(), this.deo).j(jsObject);
    }

    @NonNull
    private b aFR() {
        if (this.dli == null) {
            this.dli = new b();
        }
        return this.dli;
    }
}
