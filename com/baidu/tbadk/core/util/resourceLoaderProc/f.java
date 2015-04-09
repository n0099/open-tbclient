package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean WH;
    private boolean WI;
    private boolean WJ;
    private int WM;
    private int WN;

    public f(boolean z, boolean z2, boolean z3) {
        this.WH = true;
        this.WI = false;
        this.WJ = false;
        this.WM = 0;
        this.WN = 0;
        this.WH = z;
        this.WI = z2;
        this.WJ = z3;
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        this.WM = M <= 0 ? 200 : M;
        if (this.WM > 480) {
            this.WM = 480;
        }
        if (this.WM > com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.WM = com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.WN = (int) (this.WM * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.iI() ? this.WM : this.WN;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.WH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tz() {
        return this.WJ;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tA() {
        return this.WI;
    }
}
