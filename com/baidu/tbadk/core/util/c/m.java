package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private boolean aiG;
    private boolean aiH;
    private boolean aiI;
    private int height;
    private int procType;
    private int width;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aiG = true;
        this.aiH = false;
        this.aiI = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aiG = z;
        this.aiH = z2;
        this.aiI = z3;
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
        return this.aiG;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vW() {
        return this.aiI;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return this.aiH;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vY() {
        return this.procType;
    }
}
