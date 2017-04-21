package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aid;
    private boolean aie;
    private boolean aif;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aid = true;
        this.aie = false;
        this.aif = false;
        this.procType = 0;
        this.aid = z;
        this.aie = z2;
        this.aif = z3;
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
        return this.aid;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wC() {
        return this.aif;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wD() {
        return this.aie;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wE() {
        return this.procType;
    }
}
