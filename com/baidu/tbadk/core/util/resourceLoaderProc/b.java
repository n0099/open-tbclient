package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aec;
    private boolean aed;
    private boolean aee;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.aec = true;
        this.aed = false;
        this.aee = false;
        this.aec = z;
        this.aed = z2;
        this.aee = z3;
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
        return this.aec;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vC() {
        return this.aee;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vD() {
        return this.aed;
    }
}
