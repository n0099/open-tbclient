package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dsZ;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aFr() {
        if (!TextUtils.isEmpty(this.dsZ)) {
            return this.dsZ;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.dsZ = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.qU(this.dsZ)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.dsZ;
    }
}
