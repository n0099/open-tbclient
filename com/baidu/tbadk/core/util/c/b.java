package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ajf;
    private boolean ajg;
    private boolean ajh;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ajf = true;
        this.ajg = false;
        this.ajh = false;
        this.procType = 0;
        this.ajf = z;
        this.ajg = z2;
        this.ajh = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.k.ad(TbadkCoreApplication.getInst().getApp());
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
        return this.ajf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ws() {
        return this.ajh;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wt() {
        return this.ajg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wu() {
        return this.procType;
    }
}
