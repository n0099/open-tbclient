package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends a {
    private int acq;
    private boolean aeC;
    private boolean aeD;
    private boolean aeE;
    private int height;
    private int width;

    public k(boolean z, boolean z2, boolean z3, int i) {
        this.aeC = true;
        this.aeD = false;
        this.aeE = false;
        this.acq = 0;
        this.width = 0;
        this.height = 0;
        this.aeC = z;
        this.aeD = z2;
        this.aeE = z3;
        this.acq = i;
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
        return this.aeC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wI() {
        return this.aeE;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wJ() {
        return this.aeD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wK() {
        return this.acq;
    }
}
