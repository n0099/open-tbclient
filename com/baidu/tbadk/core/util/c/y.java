package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class y extends a {
    private int procType;

    public y(int i) {
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
    public boolean aGX() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aGY() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aGZ() {
        return this.procType;
    }
}
