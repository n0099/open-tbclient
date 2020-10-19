package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean akj;
    private boolean eBf;
    private boolean eBg;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.akj = true;
        this.eBf = false;
        this.eBg = false;
        this.procType = 0;
        this.akj = z;
        this.eBf = z2;
        this.eBg = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return (int) (this.width * this.scale);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.akj;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bnn() {
        return this.eBg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bno() {
        return this.eBf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bnp() {
        return this.procType;
    }
}
