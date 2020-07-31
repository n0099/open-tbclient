package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cAz;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String apm() {
        if (!TextUtils.isEmpty(this.cAz)) {
            return this.cAz;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.cAz = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.nI(this.cAz)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.cAz;
    }
}
