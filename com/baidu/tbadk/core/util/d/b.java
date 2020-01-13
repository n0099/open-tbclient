package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean Nj;
    private boolean cXw;
    private boolean cXx;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.Nj = true;
        this.cXw = false;
        this.cXx = false;
        this.procType = 0;
        this.Nj = z;
        this.cXw = z2;
        this.cXx = z3;
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
        return this.Nj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEE() {
        return this.cXx;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEF() {
        return this.cXw;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEG() {
        return this.procType;
    }
}
