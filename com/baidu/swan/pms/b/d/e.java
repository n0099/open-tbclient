package com.baidu.swan.pms.b.d;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
/* loaded from: classes2.dex */
public abstract class e {
    private int btR;
    private String mFrom = LivenessStat.TYPE_STRING_DEFAULT;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(int i) {
        this.btR = i;
    }

    public int Bx() {
        return this.btR;
    }

    public e kC(String str) {
        this.mFrom = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }
}
