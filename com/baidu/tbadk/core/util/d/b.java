package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aAb;
    private boolean aAc;
    private boolean aAd;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aAb = true;
        this.aAc = false;
        this.aAd = false;
        this.procType = 0;
        this.aAb = z;
        this.aAc = z2;
        this.aAd = z3;
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
        return this.aAb;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dk() {
        return this.aAd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dl() {
        return this.aAc;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dm() {
        return this.procType;
    }
}
