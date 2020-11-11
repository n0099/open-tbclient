package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cTw;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cAM = str;
        this.cTw = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String ok(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cTw.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cTw.data) + com.baidu.swan.apps.event.a.I(str, "message", this.cTw.message);
    }
}
