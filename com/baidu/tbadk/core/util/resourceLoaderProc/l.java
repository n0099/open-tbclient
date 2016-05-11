package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private int Xc;
    private boolean Zv;
    private boolean Zw;
    private boolean Zx;
    private int height;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.Zv = true;
        this.Zw = false;
        this.Zx = false;
        this.Xc = 0;
        this.width = 0;
        this.height = 0;
        this.Zv = z;
        this.Zw = z2;
        this.Zx = z3;
        this.Xc = i;
        this.width = Math.min(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m11getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
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
        return this.Zv;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uH() {
        return this.Zx;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return this.Zw;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Xc;
    }
}
