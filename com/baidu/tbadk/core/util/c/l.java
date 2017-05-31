package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean ahm;
    private boolean ahn;
    private boolean aho;
    private int height;
    private int procType;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.ahm = true;
        this.ahn = false;
        this.aho = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ahm = z;
        this.ahn = z2;
        this.aho = z3;
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
        return this.ahm;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vN() {
        return this.aho;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vO() {
        return this.ahn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vP() {
        return this.procType;
    }
}
