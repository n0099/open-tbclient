package com.baidu.swan.apps.core.pms;
/* loaded from: classes10.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int czo = alQ();
    private int czp = this.czo;

    protected int alQ() {
        return 0;
    }

    public j hP(int i) {
        if ((this.czp == 0 || this.czo == this.czp) && i != 0 && i != this.czp) {
            this.czp = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ami() {
        return this.czp == 0 ? this.czo : this.czp;
    }
}
