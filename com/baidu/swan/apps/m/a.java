package com.baidu.swan.apps.m;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.e.c;
import com.baidu.swan.games.e.i;
/* loaded from: classes11.dex */
public class a implements i {
    @Override // com.baidu.swan.games.e.i
    public com.baidu.swan.games.e.a a(String str, com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new c(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.e.i
    public String getUserAgent() {
        return com.baidu.swan.apps.aq.a.aox();
    }
}
