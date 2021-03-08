package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String duB;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aFu() {
        if (!TextUtils.isEmpty(this.duB)) {
            return this.duB;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.duB = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.rb(this.duB)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.duB;
    }
}
