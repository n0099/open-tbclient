package com.baidu.swan.games.network.websocket;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.games.f.b efi;
    private b elW;

    public a(com.baidu.swan.games.f.b bVar) {
        this.efi = bVar;
    }

    public c connectSocket(JsObject jsObject) {
        return new c(bbo(), this.efi).j(jsObject);
    }

    @NonNull
    private b bbo() {
        if (this.elW == null) {
            this.elW = new b();
        }
        return this.elW;
    }
}
