package com.baidu.tbadk.core.util.resourceLoaderProc;
/* loaded from: classes.dex */
public class g extends a {
    private int procType;

    public g(int i) {
        this.procType = 0;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public boolean fJ() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wh() {
        return this.procType;
    }
}
