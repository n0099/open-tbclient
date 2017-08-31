package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean ajf;
    private boolean ajg;
    private boolean ajh;
    private int ajj;
    private int ajk;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ajf = true;
        this.ajg = false;
        this.ajh = false;
        this.procType = 0;
        this.ajj = 0;
        this.ajk = 0;
        this.ajf = z;
        this.ajg = z2;
        this.ajh = z3;
        this.procType = i;
        int ad = com.baidu.adp.lib.util.k.ad(TbadkCoreApplication.getInst().getApp());
        this.ajj = ad <= 0 ? 200 : ad;
        if (this.ajj > 480) {
            this.ajj = 480;
        }
        if (this.ajj > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f)) {
            this.ajj = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f);
        }
        this.ajk = (int) (this.ajj * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hj() ? this.ajj : this.ajk;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ws() {
        return this.ajh;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wt() {
        return this.ajg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wu() {
        return this.procType;
    }
}
