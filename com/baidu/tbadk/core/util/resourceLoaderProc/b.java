package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private int Xu;
    private boolean ZM;
    private boolean ZN;
    private boolean ZO;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ZM = true;
        this.ZN = false;
        this.ZO = false;
        this.Xu = 0;
        this.ZM = z;
        this.ZN = z2;
        this.ZO = z3;
        this.Xu = i;
        this.width = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return (int) (this.width * this.scale);
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
