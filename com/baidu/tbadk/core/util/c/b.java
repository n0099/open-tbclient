package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aiu;
    private boolean aiv;
    private boolean aiw;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aiu = true;
        this.aiv = false;
        this.aiw = false;
        this.procType = 0;
        this.aiu = z;
        this.aiv = z2;
        this.aiw = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
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
        return this.aiu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vP() {
        return this.aiw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return this.aiv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vR() {
        return this.procType;
    }
}
