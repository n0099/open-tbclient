package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class r extends a {
    private int procType;

    public r(int i) {
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
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.procType;
    }
}
