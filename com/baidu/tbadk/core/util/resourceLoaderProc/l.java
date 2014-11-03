package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean GD;
    private boolean GE;
    private boolean GF;
    private int height;
    private int width;

    public l(boolean z, boolean z2, boolean z3) {
        this.GD = true;
        this.GE = false;
        this.GF = false;
        this.width = 0;
        this.height = 0;
        this.GD = z;
        this.GE = z2;
        this.GF = z3;
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
        return this.GD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return this.GF;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return this.GE;
    }
}
