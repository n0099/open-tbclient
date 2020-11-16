package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cRM;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.czc = str;
        this.cRM = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String od(String str) {
        return com.baidu.swan.apps.event.a.c(str, "status", Integer.valueOf(this.cRM.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cRM.data) + com.baidu.swan.apps.event.a.I(str, "message", this.cRM.message);
    }
}
