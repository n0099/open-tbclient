package com.baidu.swan.apps.process.b.b.c;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements a<com.baidu.swan.apps.process.b.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String baF;

    @Override // com.baidu.swan.apps.process.b.b.c.a
    public String Om() {
        if (!TextUtils.isEmpty(this.baF)) {
            return this.baF;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.baF = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.b.b.d.a.gS(this.baF)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.baF;
    }
}
