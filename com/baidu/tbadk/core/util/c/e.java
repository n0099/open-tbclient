package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean aid;
    private boolean aie;
    private boolean aif;
    private int aih;
    private int aii;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aid = true;
        this.aie = false;
        this.aif = false;
        this.procType = 0;
        this.aih = 0;
        this.aii = 0;
        this.aid = z;
        this.aie = z2;
        this.aif = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        this.aih = af <= 0 ? 200 : af;
        if (this.aih > 480) {
            this.aih = 480;
        }
        if (this.aih > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.aih = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.aii = (int) (this.aih * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hl() ? this.aih : this.aii;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aid;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wC() {
        return this.aif;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wD() {
        return this.aie;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wE() {
        return this.procType;
    }
}
