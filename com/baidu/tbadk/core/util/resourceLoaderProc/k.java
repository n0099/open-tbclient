package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends a {
    private boolean acG;
    private boolean acH;
    private boolean acI;
    private int height;
    private int width;

    public k(boolean z, boolean z2, boolean z3) {
        this.acG = true;
        this.acH = false;
        this.acI = false;
        this.width = 0;
        this.height = 0;
        this.acG = z;
        this.acH = z2;
        this.acI = z3;
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
        return this.acG;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return this.acI;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vn() {
        return this.acH;
    }
}
