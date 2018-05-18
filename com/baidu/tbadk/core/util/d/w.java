package com.baidu.tbadk.core.util.d;
/* loaded from: classes.dex */
public class w extends a {
    private int procType;

    public w(int i) {
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
    public boolean wu() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wv() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ww() {
        return this.procType;
    }
}
