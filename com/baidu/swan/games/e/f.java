package com.baidu.swan.games.e;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes2.dex */
public final class f {
    public static a a(g gVar, com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        a b = b(gVar, bVar, v8ThreadDelegatePolicy);
        b.a(new com.baidu.swan.games.e.a.b(b));
        b.a(new com.baidu.swan.games.e.a.c(b));
        b.NR();
        return b;
    }

    private static a b(g gVar, com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        h a = a(gVar);
        a a2 = a.a(gVar.getID(), bVar, v8ThreadDelegatePolicy);
        a2.setUserAgent(a.getUserAgent());
        return a2;
    }

    @NonNull
    private static h a(g gVar) {
        switch (gVar.getType()) {
            case 1:
                return new com.baidu.swan.apps.l.a();
            case 2:
                return new com.baidu.swan.apps.l.b();
            default:
                throw new IllegalArgumentException("invalid model object:" + gVar);
        }
    }
}
