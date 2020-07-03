package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cxZ;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String anC() {
        if (!TextUtils.isEmpty(this.cxZ)) {
            return this.cxZ;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.cxZ = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.nb(this.cxZ)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.cxZ;
    }
}
