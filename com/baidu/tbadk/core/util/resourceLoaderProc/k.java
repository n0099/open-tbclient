package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends a {
    private boolean adA;
    private boolean ady;
    private boolean adz;
    private int height;
    private int width;

    public k(boolean z, boolean z2, boolean z3) {
        this.ady = true;
        this.adz = false;
        this.adA = false;
        this.width = 0;
        this.height = 0;
        this.ady = z;
        this.adz = z2;
        this.adA = z3;
        this.width = Math.min(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return this.height;
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
