package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean ahU;
    private boolean ahV;
    private boolean ahW;
    private int height;
    private int procType;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.ahU = true;
        this.ahV = false;
        this.ahW = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ahU = z;
        this.ahV = z2;
        this.ahW = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ahU;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean we() {
        return this.ahW;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wf() {
        return this.ahV;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wg() {
        return this.procType;
    }
}
