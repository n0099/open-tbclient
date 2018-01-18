package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class u extends a {
    private int procType;

    public u(int i) {
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
    public boolean Dn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Do() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dp() {
        return this.procType;
    }
}
