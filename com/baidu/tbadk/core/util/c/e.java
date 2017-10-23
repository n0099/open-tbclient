package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean aiu;
    private boolean aiv;
    private boolean aiw;
    private int aiy;
    private int aiz;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aiu = true;
        this.aiv = false;
        this.aiw = false;
        this.procType = 0;
        this.aiy = 0;
        this.aiz = 0;
        this.aiu = z;
        this.aiv = z2;
        this.aiw = z3;
        this.procType = i;
        int ad = com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst().getApp());
        this.aiy = ad <= 0 ? 200 : ad;
        if (this.aiy > 480) {
            this.aiy = 480;
        }
        if (this.aiy > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f)) {
            this.aiy = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f);
        }
        this.aiz = (int) (this.aiy * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.j.hi() ? this.aiy : this.aiz;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aiu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vP() {
        return this.aiw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return this.aiv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vR() {
        return this.procType;
    }
}
