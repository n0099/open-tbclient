package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ajk;
    private boolean ajl;
    private boolean ajm;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ajk = true;
        this.ajl = false;
        this.ajm = false;
        this.procType = 0;
        this.ajk = z;
        this.ajl = z2;
        this.ajm = z3;
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
        return this.ajk;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return this.ajm;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return this.ajl;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.procType;
    }
}
