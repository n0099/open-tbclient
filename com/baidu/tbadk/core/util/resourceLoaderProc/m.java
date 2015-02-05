package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private boolean Ld;
    private boolean Le;
    private boolean Lf;
    private int height;
    private int width;

    public m(boolean z, boolean z2, boolean z3) {
        this.Ld = true;
        this.Le = false;
        this.Lf = false;
        this.width = 0;
        this.height = 0;
        this.Ld = z;
        this.Le = z2;
        this.Lf = z3;
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
        return this.Ld;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qj() {
        return this.Lf;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qk() {
        return this.Le;
    }
}
