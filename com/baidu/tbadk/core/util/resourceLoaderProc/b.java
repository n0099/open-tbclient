package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean adA;
    private boolean ady;
    private boolean adz;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.ady = true;
        this.adz = false;
        this.adA = false;
        this.ady = z;
        this.adz = z2;
        this.adA = z3;
        this.width = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 430.0f);
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
        return this.ady;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vS() {
        return this.adA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vT() {
        return this.adz;
    }
}
