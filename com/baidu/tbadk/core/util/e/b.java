package com.baidu.tbadk.core.util.e;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean Hx;
    private boolean ckO;
    private boolean ckP;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.Hx = true;
        this.ckO = false;
        this.ckP = false;
        this.procType = 0;
        this.Hx = z;
        this.ckO = z2;
        this.ckP = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return (int) (this.width * this.scale);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.Hx;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ang() {
        return this.ckP;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anh() {
        return this.ckO;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ani() {
        return this.procType;
    }
}
