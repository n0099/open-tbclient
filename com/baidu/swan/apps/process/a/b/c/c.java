package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cII;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String axi() {
        if (!TextUtils.isEmpty(this.cII)) {
            return this.cII;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.cII = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.pG(this.cII)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.cII;
    }
}
