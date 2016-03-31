package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private int abD;
    private boolean adX;
    private boolean adY;
    private boolean adZ;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.adX = true;
        this.adY = false;
        this.adZ = false;
        this.abD = 0;
        this.adX = z;
        this.adY = z2;
        this.adZ = z3;
        this.abD = i;
        this.width = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst().getApp());
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
        return this.adX;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xb() {
        return this.adZ;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xc() {
        return this.adY;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int xd() {
        return this.abD;
    }
}
