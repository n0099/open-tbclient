package com.baidu.tbadk.core.util.e;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean Yd;
    private boolean bWC;
    private boolean bWD;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.Yd = true;
        this.bWC = false;
        this.bWD = false;
        this.procType = 0;
        this.Yd = z;
        this.bWC = z2;
        this.bWD = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return (int) (this.width * this.scale);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akg() {
        return this.bWD;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akh() {
        return this.bWC;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int aki() {
        return this.procType;
    }
}
