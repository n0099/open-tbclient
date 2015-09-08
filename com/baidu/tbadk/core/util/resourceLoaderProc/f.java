package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean acB;
    private boolean acC;
    private boolean acD;
    private int acF;
    private int acG;

    public f(boolean z, boolean z2, boolean z3) {
        this.acB = true;
        this.acC = false;
        this.acD = false;
        this.acF = 0;
        this.acG = 0;
        this.acB = z;
        this.acC = z2;
        this.acD = z3;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        this.acF = K <= 0 ? 200 : K;
        if (this.acF > 480) {
            this.acF = 480;
        }
        if (this.acF > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.acF = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.acG = (int) (this.acF * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.iM() ? this.acF : this.acG;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.acB;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vn() {
        return this.acD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vo() {
        return this.acC;
    }
}
