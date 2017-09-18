package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aje;
    private boolean ajf;
    private boolean ajg;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aje = true;
        this.ajf = false;
        this.ajg = false;
        this.procType = 0;
        this.aje = z;
        this.ajf = z2;
        this.ajg = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getApp());
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
        return this.aje;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ws() {
        return this.ajg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wt() {
        return this.ajf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wu() {
        return this.procType;
    }
}
