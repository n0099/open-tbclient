package com.baidu.swan.apps.event.a;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b ddB;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cKK = str;
        this.ddB = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String oF(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.ddB.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.ddB.data) + com.baidu.swan.apps.event.a.O(str, "message", this.ddB.message);
    }
}
