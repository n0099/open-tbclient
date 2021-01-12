package com.baidu.swan.apps.m;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.f.c;
import com.baidu.swan.games.f.i;
/* loaded from: classes8.dex */
public class a implements i {
    @Override // com.baidu.swan.games.f.i
    public com.baidu.swan.games.f.a a(String str, com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new c(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.f.i
    public String getUserAgent() {
        return com.baidu.swan.apps.am.a.aMS();
    }
}
