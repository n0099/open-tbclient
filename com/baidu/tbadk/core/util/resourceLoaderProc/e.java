package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean acG;
    private boolean acH;
    private boolean acI;
    private int acK;
    private int acL;

    public e(boolean z, boolean z2, boolean z3) {
        this.acG = true;
        this.acH = false;
        this.acI = false;
        this.acK = 0;
        this.acL = 0;
        this.acG = z;
        this.acH = z2;
        this.acI = z3;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        this.acK = K <= 0 ? 200 : K;
        if (this.acK > 480) {
            this.acK = 480;
        }
        if (this.acK > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.acK = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.acL = (int) (this.acK * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.iO() ? this.acK : this.acL;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.acG;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return this.acI;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vn() {
        return this.acH;
    }
}
