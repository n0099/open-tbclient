package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean aiG;
    private boolean aiH;
    private boolean aiI;
    private int aiK;
    private int aiL;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aiG = true;
        this.aiH = false;
        this.aiI = false;
        this.procType = 0;
        this.aiK = 0;
        this.aiL = 0;
        this.aiG = z;
        this.aiH = z2;
        this.aiI = z3;
        this.procType = i;
        int ad = com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst().getApp());
        this.aiK = ad <= 0 ? 200 : ad;
        if (this.aiK > 480) {
            this.aiK = 480;
        }
        if (this.aiK > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f)) {
            this.aiK = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f);
        }
        this.aiL = (int) (this.aiK * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.j.hi() ? this.aiK : this.aiL;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
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
