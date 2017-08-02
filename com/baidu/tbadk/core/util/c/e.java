package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean aiq;
    private boolean air;
    private boolean ais;
    private int aiu;
    private int aiv;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aiq = true;
        this.air = false;
        this.ais = false;
        this.procType = 0;
        this.aiu = 0;
        this.aiv = 0;
        this.aiq = z;
        this.air = z2;
        this.ais = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
        this.aiu = af <= 0 ? 200 : af;
        if (this.aiu > 480) {
            this.aiu = 480;
        }
        if (this.aiu > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f)) {
            this.aiu = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f);
        }
        this.aiv = (int) (this.aiu * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hi() ? this.aiu : this.aiv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aiq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wk() {
        return this.ais;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wl() {
        return this.air;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wm() {
        return this.procType;
    }
}
