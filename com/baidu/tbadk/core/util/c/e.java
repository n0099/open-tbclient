package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean ajL;
    private boolean ajM;
    private boolean ajN;
    private int ajP;
    private int ajQ;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ajL = true;
        this.ajM = false;
        this.ajN = false;
        this.procType = 0;
        this.ajP = 0;
        this.ajQ = 0;
        this.ajL = z;
        this.ajM = z2;
        this.ajN = z3;
        this.procType = i;
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
        this.ajP = ag <= 0 ? 200 : ag;
        if (this.ajP > 480) {
            this.ajP = 480;
        }
        if (this.ajP > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f)) {
            this.ajP = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f);
        }
        this.ajQ = (int) (this.ajP * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hs() ? this.ajP : this.ajQ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajL;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wu() {
        return this.ajN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wv() {
        return this.ajM;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int ww() {
        return this.procType;
    }
}
