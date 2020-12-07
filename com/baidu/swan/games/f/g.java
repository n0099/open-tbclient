package com.baidu.swan.games.f;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes25.dex */
public final class g {
    public static a a(h hVar, com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        a b = b(hVar, bVar, v8ThreadDelegatePolicy);
        b.a(new com.baidu.swan.games.f.a.b(b));
        b.a(new com.baidu.swan.games.f.a.c(b));
        b.aXj();
        return b;
    }

    private static a b(h hVar, com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        i a2 = a(hVar);
        a a3 = a2.a(hVar.getID(), bVar, v8ThreadDelegatePolicy);
        a3.setUserAgent(a2.getUserAgent());
        return a3;
    }

    @NonNull
    private static i a(h hVar) {
        switch (hVar.getType()) {
            case 1:
                return new com.baidu.swan.apps.m.a();
            case 2:
                return new com.baidu.swan.apps.m.b();
            default:
                throw new IllegalArgumentException("invalid model object:" + hVar);
        }
    }
}
