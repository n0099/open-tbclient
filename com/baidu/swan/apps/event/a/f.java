package com.baidu.swan.apps.event.a;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cYL;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cFY = str;
        this.cYL = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String ns(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cYL.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cYL.data) + com.baidu.swan.apps.event.a.N(str, "message", this.cYL.message);
    }
}
