package com.baidu.tbadk.core.util.d;
/* loaded from: classes.dex */
public class y extends a {
    private int procType;

    public y(int i) {
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
    public boolean aGQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGR() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aGS() {
        return this.procType;
    }
}
