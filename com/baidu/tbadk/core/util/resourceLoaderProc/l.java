package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean acA;
    private boolean acB;
    private boolean acC;
    private int height;
    private int width;

    public l(boolean z, boolean z2, boolean z3) {
        this.acA = true;
        this.acB = false;
        this.acC = false;
        this.width = 0;
        this.height = 0;
        this.acA = z;
        this.acB = z2;
        this.acC = z3;
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
        return this.acA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vl() {
        return this.acC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return this.acB;
    }
}
