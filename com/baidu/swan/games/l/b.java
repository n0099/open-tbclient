package com.baidu.swan.games.l;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class b extends JSEvent {

    /* loaded from: classes2.dex */
    public static class a {
        @V8JavascriptField
        public boolean devhook;
        @V8JavascriptField
        public String scene;
    }

    public b(com.baidu.swan.apps.v.b.b bVar) {
        super("appshow");
        this.data = x(bVar);
    }

    private Object x(com.baidu.swan.apps.v.b.b bVar) {
        a aVar = new a();
        aVar.scene = bVar.axK;
        aVar.devhook = bVar.ayc;
        return aVar;
    }
}
