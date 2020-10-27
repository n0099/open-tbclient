package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cND;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cuT = str;
        this.cND = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nV(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cND.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cND.data) + com.baidu.swan.apps.event.a.I(str, "message", this.cND.message);
    }
}
