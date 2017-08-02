package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aiq;
    private boolean air;
    private boolean ais;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aiq = true;
        this.air = false;
        this.ais = false;
        this.procType = 0;
        this.aiq = z;
        this.air = z2;
        this.ais = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
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
        return this.aiq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wk() {
        return this.ais;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wl() {
        return this.air;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wm() {
        return this.procType;
    }
}
