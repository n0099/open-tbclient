package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean adA;
    private int adC;
    private int adD;
    private boolean ady;
    private boolean adz;

    public e(boolean z, boolean z2, boolean z3) {
        this.ady = true;
        this.adz = false;
        this.adA = false;
        this.adC = 0;
        this.adD = 0;
        this.ady = z;
        this.adz = z2;
        this.adA = z3;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        this.adC = K <= 0 ? 200 : K;
        if (this.adC > 480) {
            this.adC = 480;
        }
        if (this.adC > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.adC = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.adD = (int) (this.adC * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.iQ() ? this.adC : this.adD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.ady;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vS() {
        return this.adA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vT() {
        return this.adz;
    }
}
