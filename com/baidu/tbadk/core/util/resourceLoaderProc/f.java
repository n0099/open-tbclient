package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean acA;
    private boolean acB;
    private boolean acC;
    private int acE;
    private int acF;

    public f(boolean z, boolean z2, boolean z3) {
        this.acA = true;
        this.acB = false;
        this.acC = false;
        this.acE = 0;
        this.acF = 0;
        this.acA = z;
        this.acB = z2;
        this.acC = z3;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        this.acE = K <= 0 ? 200 : K;
        if (this.acE > 480) {
            this.acE = 480;
        }
        if (this.acE > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.acE = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.acF = (int) (this.acE * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.iN() ? this.acE : this.acF;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.acA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vl() {
        return this.acC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return this.acB;
    }
}
