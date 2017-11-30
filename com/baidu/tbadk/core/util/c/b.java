package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ajn;
    private boolean ajo;
    private boolean ajp;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ajn = true;
        this.ajo = false;
        this.ajp = false;
        this.procType = 0;
        this.ajn = z;
        this.ajo = z2;
        this.ajp = z3;
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
        return this.ajn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wa() {
        return this.ajp;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wb() {
        return this.ajo;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wc() {
        return this.procType;
    }
}
