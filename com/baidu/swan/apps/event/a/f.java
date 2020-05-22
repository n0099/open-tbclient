package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b ccP;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.bMG = str;
        this.ccP = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String kd(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.ccP.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.ccP.data) + com.baidu.swan.apps.event.a.x(str, "message", this.ccP.message);
    }
}
