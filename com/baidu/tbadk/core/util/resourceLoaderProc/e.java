package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean aec;
    private boolean aed;
    private boolean aee;
    private int aeg;
    private int aeh;

    public e(boolean z, boolean z2, boolean z3) {
        this.aec = true;
        this.aed = false;
        this.aee = false;
        this.aeg = 0;
        this.aeh = 0;
        this.aec = z;
        this.aed = z2;
        this.aee = z3;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        this.aeg = K <= 0 ? 200 : K;
        if (this.aeg > 480) {
            this.aeg = 480;
        }
        if (this.aeg > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.aeg = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.aeh = (int) (this.aeg * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.iR() ? this.aeg : this.aeh;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.aec;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vC() {
        return this.aee;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vD() {
        return this.aed;
    }
}
