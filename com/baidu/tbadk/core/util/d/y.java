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
    public boolean aEl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEm() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEn() {
        return this.procType;
    }
}
