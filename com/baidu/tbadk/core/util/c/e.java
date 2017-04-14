package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean aic;
    private boolean aid;
    private boolean aie;
    private int aig;
    private int aih;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aic = true;
        this.aid = false;
        this.aie = false;
        this.procType = 0;
        this.aig = 0;
        this.aih = 0;
        this.aic = z;
        this.aid = z2;
        this.aie = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        this.aig = af <= 0 ? 200 : af;
        if (this.aig > 480) {
            this.aig = 480;
        }
        if (this.aig > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.aig = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.aih = (int) (this.aig * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hk() ? this.aig : this.aih;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aic;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wC() {
        return this.aie;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wD() {
        return this.aid;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wE() {
        return this.procType;
    }
}
