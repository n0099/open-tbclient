package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ZP;
    private boolean bMP;
    private boolean bMQ;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ZP = true;
        this.bMP = false;
        this.bMQ = false;
        this.procType = 0;
        this.ZP = z;
        this.bMP = z2;
        this.bMQ = z3;
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
        return this.ZP;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adS() {
        return this.bMQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adT() {
        return this.bMP;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adU() {
        return this.procType;
    }
}
