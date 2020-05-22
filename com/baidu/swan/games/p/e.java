package com.baidu.swan.games.p;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class e extends JSEvent {

    /* loaded from: classes11.dex */
    public static class a {
        @V8JavascriptField
        public boolean devhook;
        @V8JavascriptField
        public String scene;
    }

    public e(com.baidu.swan.apps.v.b.b bVar) {
        super("appshow");
        this.data = r(bVar);
    }

    private Object r(com.baidu.swan.apps.v.b.b bVar) {
        a aVar = new a();
        aVar.scene = bVar.agK();
        aVar.devhook = bVar.agW();
        return aVar;
    }
}
