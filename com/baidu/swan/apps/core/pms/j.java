package com.baidu.swan.apps.core.pms;
/* loaded from: classes10.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cND = aql();
    private int cNE = this.cND;

    protected int aql() {
        return 0;
    }

    public j ik(int i) {
        if ((this.cNE == 0 || this.cND == this.cNE) && i != 0 && i != this.cNE) {
            this.cNE = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aqD() {
        return this.cNE == 0 ? this.cND : this.cNE;
    }
}
