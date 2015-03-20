package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private boolean WF;
    private boolean WG;
    private boolean WH;
    private int height;
    private int width;

    public m(boolean z, boolean z2, boolean z3) {
        this.WF = true;
        this.WG = false;
        this.WH = false;
        this.width = 0;
        this.height = 0;
        this.WF = z;
        this.WG = z2;
        this.WH = z3;
        this.width = Math.min(com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
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
        return this.WF;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tz() {
        return this.WH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tA() {
        return this.WG;
    }
}
