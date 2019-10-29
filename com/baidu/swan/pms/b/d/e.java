package com.baidu.swan.pms.b.d;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
/* loaded from: classes2.dex */
public abstract class e {
    private int mCategory;
    private String mFrom = LivenessStat.TYPE_STRING_DEFAULT;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public e lg(String str) {
        this.mFrom = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }
}
