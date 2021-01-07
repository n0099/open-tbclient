package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dvC;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aIQ() {
        if (!TextUtils.isEmpty(this.dvC)) {
            return this.dvC;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.dvC = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.rN(this.dvC)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.dvC;
    }
}
