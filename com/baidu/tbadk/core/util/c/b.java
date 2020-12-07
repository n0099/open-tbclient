package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean alo;
    private boolean eVJ;
    private boolean eVK;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.alo = true;
        this.eVJ = false;
        this.eVK = false;
        this.procType = 0;
        this.alo = z;
        this.eVJ = z2;
        this.eVK = z3;
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
        return this.alo;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bur() {
        return this.eVK;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bus() {
        return this.eVJ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int but() {
        return this.procType;
    }
}
