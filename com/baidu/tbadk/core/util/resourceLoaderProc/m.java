package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private boolean Lg;
    private boolean Lh;
    private boolean Li;
    private int height;
    private int width;

    public m(boolean z, boolean z2, boolean z3) {
        this.Lg = true;
        this.Lh = false;
        this.Li = false;
        this.width = 0;
        this.height = 0;
        this.Lg = z;
        this.Lh = z2;
        this.Li = z3;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
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
        return this.Lg;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qq() {
        return this.Li;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qr() {
        return this.Lh;
    }
}
