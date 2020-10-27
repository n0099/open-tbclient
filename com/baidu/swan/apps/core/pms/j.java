package com.baidu.swan.apps.core.pms;
/* loaded from: classes10.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cHK = anK();
    private int cHL = this.cHK;

    protected int anK() {
        return 0;
    }

    public j ia(int i) {
        if ((this.cHL == 0 || this.cHK == this.cHL) && i != 0 && i != this.cHL) {
            this.cHL = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aoc() {
        return this.cHL == 0 ? this.cHK : this.cHL;
    }
}
