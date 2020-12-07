package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes25.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cYF;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cFU = str;
        this.cYF = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String oM(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cYF.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cYF.data) + com.baidu.swan.apps.event.a.L(str, "message", this.cYF.message);
    }
}
