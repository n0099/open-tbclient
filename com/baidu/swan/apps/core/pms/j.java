package com.baidu.swan.apps.core.pms;
/* loaded from: classes8.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cWK = aqJ();
    private int cWL = this.cWK;

    protected int aqJ() {
        return 0;
    }

    public j gX(int i) {
        if ((this.cWL == 0 || this.cWK == this.cWL) && i != 0 && i != this.cWL) {
            this.cWL = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arb() {
        return this.cWL == 0 ? this.cWK : this.cWL;
    }
}
