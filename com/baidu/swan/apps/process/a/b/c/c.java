package com.baidu.swan.apps.process.a.b.c;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public abstract class c implements a<com.baidu.swan.apps.process.a.b.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cKM;

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public String axR() {
        if (!TextUtils.isEmpty(this.cKM)) {
            return this.cKM;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append("").append(hashCode());
        this.cKM = sb.toString();
        if (DEBUG && com.baidu.swan.apps.process.a.b.d.a.qa(this.cKM)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.cKM;
    }
}
