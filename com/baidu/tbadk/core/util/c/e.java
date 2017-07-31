package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean ajJ;
    private boolean ajK;
    private boolean ajL;
    private int ajN;
    private int ajO;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ajJ = true;
        this.ajK = false;
        this.ajL = false;
        this.procType = 0;
        this.ajN = 0;
        this.ajO = 0;
        this.ajJ = z;
        this.ajK = z2;
        this.ajL = z3;
        this.procType = i;
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
        this.ajN = ag <= 0 ? 200 : ag;
        if (this.ajN > 480) {
            this.ajN = 480;
        }
        if (this.ajN > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f)) {
            this.ajN = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f);
        }
        this.ajO = (int) (this.ajN * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hs() ? this.ajN : this.ajO;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajJ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wu() {
        return this.ajL;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wv() {
        return this.ajK;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int ww() {
        return this.procType;
    }
}
