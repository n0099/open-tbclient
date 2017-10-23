package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class q extends a {
    private int procType;

    public q(int i) {
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
    public boolean vP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vR() {
        return this.procType;
    }
}
