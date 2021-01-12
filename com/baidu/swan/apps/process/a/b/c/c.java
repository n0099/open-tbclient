package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dqN;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aEW() {
        if (!TextUtils.isEmpty(this.dqN)) {
            return this.dqN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.dqN = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.qC(this.dqN)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.dqN;
    }
}
