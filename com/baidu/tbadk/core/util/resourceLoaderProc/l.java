package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private int abD;
    private boolean adX;
    private boolean adY;
    private boolean adZ;
    private int height;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.adX = true;
        this.adY = false;
        this.adZ = false;
        this.abD = 0;
        this.width = 0;
        this.height = 0;
        this.adX = z;
        this.adY = z2;
        this.adZ = z3;
        this.abD = i;
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
