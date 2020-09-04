package com.baidu.swan.apps.core.pms;
/* loaded from: classes8.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int ckV = aiv();
    private int ckW = this.ckV;

    protected int aiv() {
        return 0;
    }

    public j hj(int i) {
        if ((this.ckW == 0 || this.ckV == this.ckW) && i != 0 && i != this.ckW) {
            this.ckW = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aiN() {
        return this.ckW == 0 ? this.ckV : this.ckW;
    }
}
