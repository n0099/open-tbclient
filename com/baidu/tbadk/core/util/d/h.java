package com.baidu.tbadk.core.util.d;
/* loaded from: classes.dex */
public class h extends a {
    private int procType;

    public h(int i) {
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
    public boolean DI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean np() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DK() {
        return this.procType;
    }
}
