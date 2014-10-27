package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean GC;
    private boolean GD;
    private boolean GE;
    private int height;
    private int width;

    public l(boolean z, boolean z2, boolean z3) {
        this.GC = true;
        this.GD = false;
        this.GE = false;
        this.width = 0;
        this.height = 0;
        this.GC = z;
        this.GD = z2;
        this.GE = z3;
        this.width = Math.min(com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
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
        return this.GC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return this.GE;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return this.GD;
    }
}
