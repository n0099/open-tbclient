package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private int Xu;
    private boolean ZM;
    private boolean ZN;
    private boolean ZO;
    private int height;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.ZM = true;
        this.ZN = false;
        this.ZO = false;
        this.Xu = 0;
        this.width = 0;
        this.height = 0;
        this.ZM = z;
        this.ZN = z2;
        this.ZO = z3;
        this.Xu = i;
        this.width = Math.min(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
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
