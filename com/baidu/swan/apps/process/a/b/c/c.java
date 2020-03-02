package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bIU;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aaI() {
        if (!TextUtils.isEmpty(this.bIU)) {
            return this.bIU;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.bIU = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.kq(this.bIU)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.bIU;
    }
}
