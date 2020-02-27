package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bIT;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aaG() {
        if (!TextUtils.isEmpty(this.bIT)) {
            return this.bIT;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.bIT = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.kq(this.bIT)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.bIT;
    }
}
