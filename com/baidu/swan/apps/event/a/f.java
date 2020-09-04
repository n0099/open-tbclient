package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cqT;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.bXY = str;
        this.cqT = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String mx(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cqT.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cqT.data) + com.baidu.swan.apps.event.a.A(str, "message", this.cqT.message);
    }
}
