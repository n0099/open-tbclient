package com.baidu.swan.apps.process.b.b.c;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements a<com.baidu.swan.apps.process.b.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aHJ;

    @Override // com.baidu.swan.apps.process.b.b.c.a
    public String Jr() {
        if (!TextUtils.isEmpty(this.aHJ)) {
            return this.aHJ;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.aHJ = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.b.b.d.a.gn(this.aHJ)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.aHJ;
    }
}
