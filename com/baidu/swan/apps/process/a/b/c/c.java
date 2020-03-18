package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bJg;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aaL() {
        if (!TextUtils.isEmpty(this.bJg)) {
            return this.bJg;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.bJg = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.kp(this.bJg)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.bJg;
    }
}
