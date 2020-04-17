package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String chP;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aiQ() {
        if (!TextUtils.isEmpty(this.chP)) {
            return this.chP;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.chP = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.lC(this.chP)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.chP;
    }
}
