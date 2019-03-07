package com.baidu.tbadk.core.util.d;
/* loaded from: classes.dex */
public class x extends a {
    private int procType;

    public x(int i) {
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
    public boolean adS() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adT() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adU() {
        return this.procType;
    }
}
