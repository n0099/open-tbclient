package com.baidu.swan.apps.core.pms;
/* loaded from: classes9.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cXJ = auc();
    private int cXK = this.cXJ;

    protected int auc() {
        return 0;
    }

    public j iz(int i) {
        if ((this.cXK == 0 || this.cXJ == this.cXK) && i != 0 && i != this.cXK) {
            this.cXK = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int auu() {
        return this.cXK == 0 ? this.cXJ : this.cXK;
    }
}
