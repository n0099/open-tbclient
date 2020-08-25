package com.baidu.swan.apps.core.pms;
/* loaded from: classes8.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int ckR = aiv();
    private int ckS = this.ckR;

    protected int aiv() {
        return 0;
    }

    public j hj(int i) {
        if ((this.ckS == 0 || this.ckR == this.ckS) && i != 0 && i != this.ckS) {
            this.ckS = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aiN() {
        return this.ckS == 0 ? this.ckR : this.ckS;
    }
}
