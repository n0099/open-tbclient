package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aET;
    private boolean aEU;
    private boolean aEV;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aET = true;
        this.aEU = false;
        this.aEV = false;
        this.procType = 0;
        this.aET = z;
        this.aEU = z2;
        this.aEV = z3;
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
        return this.aET;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean EI() {
        return this.aEV;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean EJ() {
        return this.aEU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int EK() {
        return this.procType;
    }
}
