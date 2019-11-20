package com.baidu.tbadk.core.util.e;
/* loaded from: classes.dex */
public class y extends a {
    private int procType;

    public y(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ang() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anh() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ani() {
        return this.procType;
    }
}
