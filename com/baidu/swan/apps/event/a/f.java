package com.baidu.swan.apps.event.a;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b dcz;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.cJT = str;
        this.dcz = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nR(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.dcz.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.dcz.data) + com.baidu.swan.apps.event.a.O(str, "message", this.dcz.message);
    }
}
