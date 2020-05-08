package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String chV;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aiP() {
        if (!TextUtils.isEmpty(this.chV)) {
            return this.chV;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.chV = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.lC(this.chV)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.chV;
    }
}
