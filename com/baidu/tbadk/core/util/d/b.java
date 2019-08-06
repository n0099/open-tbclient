package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean Yd;
    private boolean bVL;
    private boolean bVM;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.Yd = true;
        this.bVL = false;
        this.bVM = false;
        this.procType = 0;
        this.Yd = z;
        this.bVL = z2;
        this.bVM = z3;
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
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajU() {
        return this.bVM;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajV() {
        return this.bVL;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ajW() {
        return this.procType;
    }
}
