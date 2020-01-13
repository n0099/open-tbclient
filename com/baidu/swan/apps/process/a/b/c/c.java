package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bEO;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String Ys() {
        if (!TextUtils.isEmpty(this.bEO)) {
            return this.bEO;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.bEO = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.kb(this.bEO)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.bEO;
    }
}
