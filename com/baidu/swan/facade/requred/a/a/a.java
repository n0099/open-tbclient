package com.baidu.swan.facade.requred.a.a;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.adaptation.a.ao;
import com.baidu.swan.game.ad.f.m;
import com.baidu.swan.games.a.c;
/* loaded from: classes11.dex */
public class a implements ao {
    @Override // com.baidu.swan.apps.adaptation.a.ao
    public c a(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        return new m(bVar, jsObject);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public com.baidu.swan.games.a.b b(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        return new com.baidu.swan.game.ad.f.c(bVar, jsObject);
    }
}
