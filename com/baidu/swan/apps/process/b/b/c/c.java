package com.baidu.swan.apps.process.b.b.c;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements a<com.baidu.swan.apps.process.b.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aEJ;

    @Override // com.baidu.swan.apps.process.b.b.c.a
    public String Gk() {
        if (!TextUtils.isEmpty(this.aEJ)) {
            return this.aEJ;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.aEJ = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.b.b.d.a.fO(this.aEJ)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.aEJ;
    }
}
