package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class z extends a {
    private int procType;

    public z(int i) {
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
    public boolean bqU() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bqV() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bqW() {
        return this.procType;
    }
}
