package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean WF;
    private boolean WG;
    private boolean WH;
    private int WK;
    private int WL;

    public f(boolean z, boolean z2, boolean z3) {
        this.WF = true;
        this.WG = false;
        this.WH = false;
        this.WK = 0;
        this.WL = 0;
        this.WF = z;
        this.WG = z2;
        this.WH = z3;
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        this.WK = M <= 0 ? 200 : M;
        if (this.WK > 480) {
            this.WK = 480;
        }
        if (this.WK > com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.WK = com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.WL = (int) (this.WK * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.iI() ? this.WK : this.WL;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.WF;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tz() {
        return this.WH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tA() {
        return this.WG;
    }
}
