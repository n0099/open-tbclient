package com.baidu.swan.apps.event.a;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class f extends a {
    private final com.baidu.swan.apps.api.c.b cjC;

    public f(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
        this.bSl = str;
        this.cjC = bVar;
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String kH(String str) {
        return com.baidu.swan.apps.event.a.d(str, "status", Integer.valueOf(this.cjC.status)) + com.baidu.swan.apps.event.a.c(str, "data", this.cjC.data) + com.baidu.swan.apps.event.a.y(str, "message", this.cjC.message);
    }
}
