package com.baidu.tbadk.core.util.e;
/* loaded from: classes.dex */
public class x extends a {
    private int procType;

    public x(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akh() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int aki() {
        return this.procType;
    }
}
