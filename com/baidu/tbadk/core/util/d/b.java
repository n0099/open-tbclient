package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean Nf;
    private boolean cXm;
    private boolean cXn;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.Nf = true;
        this.cXm = false;
        this.cXn = false;
        this.procType = 0;
        this.Nf = z;
        this.cXm = z2;
        this.cXn = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return (int) (this.width * this.scale);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.Nf;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEl() {
        return this.cXn;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEm() {
        return this.cXm;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEn() {
        return this.procType;
    }
}
