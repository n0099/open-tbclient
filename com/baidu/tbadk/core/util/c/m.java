package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private boolean aiu;
    private boolean aiv;
    private boolean aiw;
    private int height;
    private int procType;
    private int width;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aiu = true;
        this.aiv = false;
        this.aiw = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aiu = z;
        this.aiv = z2;
        this.aiw = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
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
        return this.aiu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vP() {
        return this.aiw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return this.aiv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vR() {
        return this.procType;
    }
}
