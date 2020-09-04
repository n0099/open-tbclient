package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cIM;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String axi() {
        if (!TextUtils.isEmpty(this.cIM)) {
            return this.cIM;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.cIM = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.pH(this.cIM)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.cIM;
    }
}
