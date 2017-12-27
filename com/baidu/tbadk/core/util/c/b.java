package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aXt;
    private boolean aXu;
    private boolean aXv;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aXt = true;
        this.aXu = false;
        this.aXv = false;
        this.procType = 0;
        this.aXt = z;
        this.aXu = z2;
        this.aXv = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
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
        return this.aXt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dw() {
        return this.aXv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dx() {
        return this.aXu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dy() {
        return this.procType;
    }
}
