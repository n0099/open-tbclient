package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ZO;
    private boolean bMO;
    private boolean bMP;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ZO = true;
        this.bMO = false;
        this.bMP = false;
        this.procType = 0;
        this.ZO = z;
        this.bMO = z2;
        this.bMP = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
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
        return this.ZO;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adS() {
        return this.bMP;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adT() {
        return this.bMO;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adU() {
        return this.procType;
    }
}
