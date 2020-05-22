package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String ctl;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String amw() {
        if (!TextUtils.isEmpty(this.ctl)) {
            return this.ctl;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.ctl = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.mT(this.ctl)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.ctl;
    }
}
