package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int ahA;
    private boolean ahv;
    private boolean ahw;
    private boolean ahx;
    private int ahz;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ahv = true;
        this.ahw = false;
        this.ahx = false;
        this.procType = 0;
        this.ahz = 0;
        this.ahA = 0;
        this.ahv = z;
        this.ahw = z2;
        this.ahx = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        this.ahz = af <= 0 ? 200 : af;
        if (this.ahz > 480) {
            this.ahz = 480;
        }
        if (this.ahz > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.ahz = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.ahA = (int) (this.ahz * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hl() ? this.ahz : this.ahA;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
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
