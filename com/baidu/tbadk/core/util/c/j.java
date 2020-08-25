package com.baidu.tbadk.core.util.c;
/* loaded from: classes2.dex */
public class j extends a {
    private int procType;

    public j(int i) {
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
    public boolean bjI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public boolean mP() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bjK() {
        return this.procType;
    }
}
