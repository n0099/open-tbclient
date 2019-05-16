package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean XJ;
    private boolean bUD;
    private boolean bUE;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.XJ = true;
        this.bUD = false;
        this.bUE = false;
        this.procType = 0;
        this.XJ = z;
        this.bUD = z2;
        this.bUE = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return (int) (this.width * this.scale);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.XJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiO() {
        return this.bUE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiP() {
        return this.bUD;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aiQ() {
        return this.procType;
    }
}
