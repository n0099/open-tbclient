package com.baidu.swan.apps.core.pms;
/* loaded from: classes7.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cLT = apD();
    private int cLU = this.cLT;

    protected int apD() {
        return 0;
    }

    public j ig(int i) {
        if ((this.cLU == 0 || this.cLT == this.cLU) && i != 0 && i != this.cLU) {
            this.cLU = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int apV() {
        return this.cLU == 0 ? this.cLT : this.cLU;
    }
}
