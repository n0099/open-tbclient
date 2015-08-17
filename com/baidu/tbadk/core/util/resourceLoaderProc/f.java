package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean acq;
    private boolean acr;
    private boolean acs;
    private int acv;
    private int acw;

    public f(boolean z, boolean z2, boolean z3) {
        this.acq = true;
        this.acr = false;
        this.acs = false;
        this.acv = 0;
        this.acw = 0;
        this.acq = z;
        this.acr = z2;
        this.acs = z3;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        this.acv = K <= 0 ? 200 : K;
        if (this.acv > 480) {
            this.acv = 480;
        }
        if (this.acv > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.acv = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.acw = (int) (this.acv * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.iP() ? this.acv : this.acw;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.acq;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vi() {
        return this.acs;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vj() {
        return this.acr;
    }
}
