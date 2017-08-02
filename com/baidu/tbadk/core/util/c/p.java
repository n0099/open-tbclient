package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class p extends a {
    private int procType;

    public p(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wl() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wm() {
        return this.procType;
    }
}
