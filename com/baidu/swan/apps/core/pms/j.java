package com.baidu.swan.apps.core.pms;
/* loaded from: classes3.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cmX = ajf();
    private int cmY = this.cmX;

    protected int ajf() {
        return 0;
    }

    public j hs(int i) {
        if ((this.cmY == 0 || this.cmX == this.cmY) && i != 0 && i != this.cmY) {
            this.cmY = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ajx() {
        return this.cmY == 0 ? this.cmX : this.cmY;
    }
}
