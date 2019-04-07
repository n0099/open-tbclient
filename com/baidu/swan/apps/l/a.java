package com.baidu.swan.apps.l;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.e.c;
import com.baidu.swan.games.e.h;
/* loaded from: classes2.dex */
public class a implements h {
    @Override // com.baidu.swan.games.e.h
    public com.baidu.swan.games.e.a a(String str, com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new c(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.e.h
    public String getUserAgent() {
        return com.baidu.swan.apps.al.a.LG();
    }
}
