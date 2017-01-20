package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean acA;
    private int acC;
    private int acD;
    private boolean acy;
    private boolean acz;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.acy = true;
        this.acz = false;
        this.acA = false;
        this.procType = 0;
        this.acC = 0;
        this.acD = 0;
        this.acy = z;
        this.acz = z2;
        this.acA = z3;
        this.procType = i;
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        this.acC = I <= 0 ? 200 : I;
        if (this.acC > 480) {
            this.acC = 480;
        }
        if (this.acC > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.acC = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.acD = (int) (this.acC * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.gl() ? this.acC : this.acD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.acy;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vI() {
        return this.acA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vJ() {
        return this.acz;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vK() {
        return this.procType;
    }
}
