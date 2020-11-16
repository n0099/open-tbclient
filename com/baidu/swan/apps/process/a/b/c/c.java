package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String djE;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aEo() {
        if (!TextUtils.isEmpty(this.djE)) {
            return this.djE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.djE = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.rn(this.djE)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.djE;
    }
}
