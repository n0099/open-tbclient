package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean ahO;
    private boolean ahP;
    private boolean ahQ;
    private int height;
    private int procType;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.ahO = true;
        this.ahP = false;
        this.ahQ = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ahO = z;
        this.ahP = z2;
        this.ahQ = z3;
        this.procType = i;
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
        return this.ahO;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return this.ahQ;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wg() {
        return this.ahP;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wh() {
        return this.procType;
    }
}
