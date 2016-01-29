package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int acq;
    private boolean aeC;
    private boolean aeD;
    private boolean aeE;
    private int aeG;
    private int aeH;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aeC = true;
        this.aeD = false;
        this.aeE = false;
        this.acq = 0;
        this.aeG = 0;
        this.aeH = 0;
        this.aeC = z;
        this.aeD = z2;
        this.aeE = z3;
        this.acq = i;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        this.aeG = K <= 0 ? 200 : K;
        if (this.aeG > 480) {
            this.aeG = 480;
        }
        if (this.aeG > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.aeG = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.aeH = (int) (this.aeG * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.ja() ? this.aeG : this.aeH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.aeC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wI() {
        return this.aeE;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wJ() {
        return this.aeD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wK() {
        return this.acq;
    }
}
