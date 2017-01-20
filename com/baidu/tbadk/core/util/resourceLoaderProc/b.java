package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean acA;
    private boolean acy;
    private boolean acz;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.acy = true;
        this.acz = false;
        this.acA = false;
        this.procType = 0;
        this.acy = z;
        this.acz = z2;
        this.acA = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
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
