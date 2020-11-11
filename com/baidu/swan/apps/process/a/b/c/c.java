package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dll;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String aEW() {
        if (!TextUtils.isEmpty(this.dll)) {
            return this.dll;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.dll = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.rt(this.dll)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.dll;
    }
}
