package com.baidu.swan.games.p;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public class b extends JSEvent {

    /* loaded from: classes9.dex */
    public static class a {
        @V8JavascriptField
        public long startupTime;
    }

    public b(long j) {
        super("appAttach");
        this.data = dl(j);
    }

    private Object dl(long j) {
        a aVar = new a();
        aVar.startupTime = j;
        return aVar;
    }
}
