package com.baidu.swan.apps.event.a;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b daX;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cIt = str;
        this.daX = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nK(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.daX.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.daX.data) + com.baidu.swan.apps.event.a.O(str, "message", this.daX.message);
    }
}
