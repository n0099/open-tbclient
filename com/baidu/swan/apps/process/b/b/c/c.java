package com.baidu.swan.apps.process.b.b.c;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements a<com.baidu.swan.apps.process.b.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aHl;

    @Override // com.baidu.swan.apps.process.b.b.c.a
    public String Jn() {
        if (!TextUtils.isEmpty(this.aHl)) {
            return this.aHl;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.aHl = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.b.b.d.a.gl(this.aHl)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.aHl;
    }
}
