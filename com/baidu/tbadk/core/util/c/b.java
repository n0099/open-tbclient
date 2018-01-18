package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aXs;
    private boolean aXt;
    private boolean aXu;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aXs = true;
        this.aXt = false;
        this.aXu = false;
        this.procType = 0;
        this.aXs = z;
        this.aXt = z2;
        this.aXu = z3;
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
        return this.aXs;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dn() {
        return this.aXu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Do() {
        return this.aXt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dp() {
        return this.procType;
    }
}
