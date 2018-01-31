package com.baidu.tbadk.core.util.d;
/* loaded from: classes.dex */
public class u extends a {
    private int procType;

    public u(int i) {
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
    public boolean Dp() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dq() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dr() {
        return this.procType;
    }
}
