package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b chD;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.bRu = str;
        this.chD = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String kl(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.chD.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.chD.data) + com.baidu.swan.apps.event.a.y(str, "message", this.chD.message);
    }
}
