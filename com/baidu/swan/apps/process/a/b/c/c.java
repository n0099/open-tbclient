package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes25.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dqD;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aHw() {
        if (!TextUtils.isEmpty(this.dqD)) {
            return this.dqD;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.dqD = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.rU(this.dqD)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.dqD;
    }
}
