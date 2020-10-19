package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cWP;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aAC() {
        if (!TextUtils.isEmpty(this.cWP)) {
            return this.cWP;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.cWP = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.qM(this.cWP)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.cWP;
    }
}
