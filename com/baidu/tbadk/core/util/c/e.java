package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean ahU;
    private boolean ahV;
    private boolean ahW;
    private int ahY;
    private int ahZ;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ahU = true;
        this.ahV = false;
        this.ahW = false;
        this.procType = 0;
        this.ahY = 0;
        this.ahZ = 0;
        this.ahU = z;
        this.ahV = z2;
        this.ahW = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        this.ahY = af <= 0 ? 200 : af;
        if (this.ahY > 480) {
            this.ahY = 480;
        }
        if (this.ahY > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.ahY = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.ahZ = (int) (this.ahY * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hk() ? this.ahY : this.ahZ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
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
