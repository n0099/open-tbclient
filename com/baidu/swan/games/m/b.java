package com.baidu.swan.games.m;

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
        this.data = z(bVar);
    }

    private Object z(com.baidu.swan.apps.v.b.b bVar) {
        a aVar = new a();
        aVar.scene = bVar.FK();
        aVar.devhook = bVar.FV();
        return aVar;
    }
}
