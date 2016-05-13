package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int Xc;
    private int ZA;
    private boolean Zv;
    private boolean Zw;
    private boolean Zx;
    private int Zz;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.Zv = true;
        this.Zw = false;
        this.Zx = false;
        this.Xc = 0;
        this.Zz = 0;
        this.ZA = 0;
        this.Zv = z;
        this.Zw = z2;
        this.Zx = z3;
        this.Xc = i;
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst().getApp());
        this.Zz = B <= 0 ? 200 : B;
        if (this.Zz > 480) {
            this.Zz = 480;
        }
        if (this.Zz > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m11getInst().getApp(), 320.0f)) {
            this.Zz = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m11getInst().getApp(), 320.0f);
        }
        this.ZA = (int) (this.Zz * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.fr() ? this.Zz : this.ZA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.Zv;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return this.Zx;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uJ() {
        return this.Zw;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uK() {
        return this.Xc;
    }
}
