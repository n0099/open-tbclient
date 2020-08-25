package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cqP;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.bXU = str;
        this.cqP = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String mw(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cqP.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cqP.data) + com.baidu.swan.apps.event.a.A(str, "message", this.cqP.message);
    }
}
