package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ajL;
    private boolean ajM;
    private boolean ajN;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ajL = true;
        this.ajM = false;
        this.ajN = false;
        this.procType = 0;
        this.ajL = z;
        this.ajM = z2;
        this.ajN = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
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
        return this.ajL;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wu() {
        return this.ajN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wv() {
        return this.ajM;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int ww() {
        return this.procType;
    }
}
