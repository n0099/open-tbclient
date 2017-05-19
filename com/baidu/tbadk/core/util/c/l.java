package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean ahv;
    private boolean ahw;
    private boolean ahx;
    private int height;
    private int procType;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.ahv = true;
        this.ahw = false;
        this.ahx = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ahv = z;
        this.ahw = z2;
        this.ahx = z3;
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
        return this.ahv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return this.ahx;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vR() {
        return this.ahw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vS() {
        return this.procType;
    }
}
