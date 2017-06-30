package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ahU;
    private boolean ahV;
    private boolean ahW;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ahU = true;
        this.ahV = false;
        this.ahW = false;
        this.procType = 0;
        this.ahU = z;
        this.ahV = z2;
        this.ahW = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f);
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
        return this.ahU;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean we() {
        return this.ahW;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wf() {
        return this.ahV;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wg() {
        return this.procType;
    }
}
