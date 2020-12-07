package com.baidu.swan.apps.core.pms;
/* loaded from: classes25.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cSM = asL();
    private int cSN = this.cSM;

    protected int asL() {
        return 0;
    }

    public j iE(int i) {
        if ((this.cSN == 0 || this.cSM == this.cSN) && i != 0 && i != this.cSN) {
            this.cSN = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int atd() {
        return this.cSN == 0 ? this.cSM : this.cSN;
    }
}
