package com.baidu.swan.apps.core.pms;
/* loaded from: classes7.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.b.b {
    private final int ceA = abW();
    private int ceB = this.ceA;

    protected int abW() {
        return 0;
    }

    public j fn(int i) {
        if ((this.ceB == 0 || this.ceA == this.ceB) && i != 0 && i != this.ceB) {
            this.ceB = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aco() {
        return this.ceB == 0 ? this.ceA : this.ceB;
    }
}
