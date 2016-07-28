package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int Yd;
    private int aaA;
    private boolean aav;
    private boolean aaw;
    private boolean aax;
    private int aaz;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aav = true;
        this.aaw = false;
        this.aax = false;
        this.Yd = 0;
        this.aaz = 0;
        this.aaA = 0;
        this.aav = z;
        this.aaw = z2;
        this.aax = z3;
        this.Yd = i;
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst().getApp());
        this.aaz = A <= 0 ? 200 : A;
        if (this.aaz > 480) {
            this.aaz = 480;
        }
        if (this.aaz > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m10getInst().getApp(), 320.0f)) {
            this.aaz = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m10getInst().getApp(), 320.0f);
        }
        this.aaA = (int) (this.aaz * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.fr() ? this.aaz : this.aaA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.aav;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uH() {
        return this.aax;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return this.aaw;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Yd;
    }
}
