package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean akC;
    private boolean akD;
    private boolean akE;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.akC = true;
        this.akD = false;
        this.akE = false;
        this.procType = 0;
        this.akC = z;
        this.akD = z2;
        this.akE = z3;
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
        return this.akC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wv() {
        return this.akE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ww() {
        return this.akD;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int wx() {
        return this.procType;
    }
}
