package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class b extends a {
    private boolean ajr;
    private boolean emw;
    private boolean emx;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ajr = true;
        this.emw = false;
        this.emx = false;
        this.procType = 0;
        this.ajr = z;
        this.emw = z2;
        this.emx = z3;
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
        return this.ajr;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjI() {
        return this.emx;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjJ() {
        return this.emw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bjK() {
        return this.procType;
    }
}
