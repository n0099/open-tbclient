package com.baidu.swan.apps.core.pms;
/* loaded from: classes8.dex */
public abstract class j extends com.baidu.swan.pms.a.g implements com.baidu.swan.apps.env.c.b {
    private final int cSX = aqi();
    private int cSY = this.cSX;

    protected int aqi() {
        return 0;
    }

    public j gT(int i) {
        if ((this.cSY == 0 || this.cSX == this.cSY) && i != 0 && i != this.cSY) {
            this.cSY = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aqA() {
        return this.cSY == 0 ? this.cSX : this.cSY;
    }
}
