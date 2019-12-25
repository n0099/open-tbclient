package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bEd;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String XV() {
        if (!TextUtils.isEmpty(this.bEd)) {
            return this.bEd;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.bEd = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.jY(this.bEd)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.bEd;
    }
}
