package com.baidu.swan.apps.core.pms;
/* loaded from: classes9.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cVk = aqG();
    private int cVl = this.cVk;

    protected int aqG() {
        return 0;
    }

    public j gW(int i) {
        if ((this.cVl == 0 || this.cVk == this.cVl) && i != 0 && i != this.cVl) {
            this.cVl = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aqY() {
        return this.cVl == 0 ? this.cVk : this.cVl;
    }
}
