package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int Xu;
    private boolean ZM;
    private boolean ZN;
    private boolean ZO;
    private int ZQ;
    private int ZR;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ZM = true;
        this.ZN = false;
        this.ZO = false;
        this.Xu = 0;
        this.ZQ = 0;
        this.ZR = 0;
        this.ZM = z;
        this.ZN = z2;
        this.ZO = z3;
        this.Xu = i;
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getApp());
        this.ZQ = A <= 0 ? 200 : A;
        if (this.ZQ > 480) {
            this.ZQ = 480;
        }
        if (this.ZQ > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.ZQ = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.ZR = (int) (this.ZQ * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.fs() ? this.ZQ : this.ZR;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.ZM;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uH() {
        return this.ZO;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return this.ZN;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Xu;
    }
}
