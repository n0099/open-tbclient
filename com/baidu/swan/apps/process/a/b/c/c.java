package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dfq;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aCw() {
        if (!TextUtils.isEmpty(this.dfq)) {
            return this.dfq;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.dfq = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.rf(this.dfq)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.dfq;
    }
}
