package com.baidu.tbadk.core.util.d;
/* loaded from: classes.dex */
public class h extends a {
    private int procType;

    public h(int i) {
        this.procType = 0;
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
    public boolean zV() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean ij() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
        return this.procType;
    }
}
