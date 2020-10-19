package com.baidu.swan.games.p;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public class e extends JSEvent {

    /* loaded from: classes10.dex */
    public static class a {
        @V8JavascriptField
        public boolean devhook;
        @V8JavascriptField
        public String scene;
    }

    public e(com.baidu.swan.apps.u.c.b bVar) {
        super("appshow");
        this.data = q(bVar);
    }

    private Object q(com.baidu.swan.apps.u.c.b bVar) {
        a aVar = new a();
        aVar.scene = bVar.auj();
        aVar.devhook = bVar.auv();
        return aVar;
    }
}
