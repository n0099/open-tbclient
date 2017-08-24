package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class g extends a {
    private int procType;

    public g(int i) {
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
    public boolean wv() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ww() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fX() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wx() {
        return this.procType;
    }
}
