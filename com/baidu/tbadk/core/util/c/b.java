package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aiR;
    private boolean aiS;
    private boolean aiT;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aiR = true;
        this.aiS = false;
        this.aiT = false;
        this.procType = 0;
        this.aiR = z;
        this.aiS = z2;
        this.aiT = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getApp());
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
        return this.aiR;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return this.aiT;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return this.aiS;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.procType;
    }
}
