package com.baidu.tbadk.core.util.c;
/* loaded from: classes.dex */
public class t extends a {
    private int procType;

    public t(int i) {
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
    public boolean wa() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wb() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wc() {
        return this.procType;
    }
}
