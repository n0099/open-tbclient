package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class i extends a {
    private int procType;

    public i(int i) {
        this.procType = 0;
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
    public boolean aGT() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aGU() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public boolean gu() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aGV() {
        return this.procType;
    }
}
