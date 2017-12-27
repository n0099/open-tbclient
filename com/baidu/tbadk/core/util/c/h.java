package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class h extends a {
    private int procType;

    public h(int i) {
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
    public boolean Dw() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dx() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean no() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dy() {
        return this.procType;
    }
}
