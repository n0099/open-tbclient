package com.baidu.tbadk.core.util.d;
/* loaded from: classes.dex */
public class i extends a {
    private int procType;

    public i(int i) {
        this.procType = 0;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGS() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGT() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public boolean gu() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aGU() {
        return this.procType;
    }
}
