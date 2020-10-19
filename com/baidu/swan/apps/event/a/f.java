package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cFh;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cmp = str;
        this.cFh = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nC(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cFh.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cFh.data) + com.baidu.swan.apps.event.a.B(str, "message", this.cFh.message);
    }
}
