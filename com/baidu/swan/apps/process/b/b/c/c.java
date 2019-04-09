package com.baidu.swan.apps.process.b.b.c;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements a<com.baidu.swan.apps.process.b.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aEK;

    @Override // com.baidu.swan.apps.process.b.b.c.a
    public String Gk() {
        if (!TextUtils.isEmpty(this.aEK)) {
            return this.aEK;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.aEK = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.b.b.d.a.fO(this.aEK)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.aEK;
    }
}
