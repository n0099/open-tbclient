package com.baidu.swan.apps.process.b.b.c;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements a<com.baidu.swan.apps.process.b.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aGD;

    @Override // com.baidu.swan.apps.process.b.b.c.a
    public String IA() {
        if (!TextUtils.isEmpty(this.aGD)) {
            return this.aGD;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.aGD = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.b.b.d.a.gg(this.aGD)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.aGD;
    }
}
