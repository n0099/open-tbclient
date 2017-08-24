package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private boolean ajL;
    private boolean ajM;
    private boolean ajN;
    private int height;
    private int procType;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.ajL = true;
        this.ajM = false;
        this.ajN = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ajL = z;
        this.ajM = z2;
        this.ajN = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
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
        return this.ajL;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wv() {
        return this.ajN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ww() {
        return this.ajM;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wx() {
        return this.procType;
    }
}
