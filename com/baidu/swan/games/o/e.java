package com.baidu.swan.games.o;

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

    public e(com.baidu.swan.apps.x.b.b bVar) {
        super("appshow");
        this.data = p(bVar);
    }

    private Object p(com.baidu.swan.apps.x.b.b bVar) {
        a aVar = new a();
        aVar.scene = bVar.VM();
        aVar.devhook = bVar.VY();
        return aVar;
    }
}
