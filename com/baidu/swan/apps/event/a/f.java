package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b csW;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.bZZ = str;
        this.csW = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String mQ(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.csW.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.csW.data) + com.baidu.swan.apps.event.a.A(str, "message", this.csW.message);
    }
}
