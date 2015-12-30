package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends a {
    private boolean aec;
    private boolean aed;
    private boolean aee;
    private int height;
    private int width;

    public k(boolean z, boolean z2, boolean z3) {
        this.aec = true;
        this.aed = false;
        this.aee = false;
        this.width = 0;
        this.height = 0;
        this.aec = z;
        this.aed = z2;
        this.aee = z3;
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
