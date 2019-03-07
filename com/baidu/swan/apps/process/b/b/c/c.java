package com.baidu.swan.apps.process.b.b.c;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements a<com.baidu.swan.apps.process.b.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private String aEF;

    @Override // com.baidu.swan.apps.process.b.b.c.a
    public String Gm() {
        if (!TextUtils.isEmpty(this.aEF)) {
            return this.aEF;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.aEF = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.b.b.d.a.fN(this.aEF)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.aEF;
    }
}
