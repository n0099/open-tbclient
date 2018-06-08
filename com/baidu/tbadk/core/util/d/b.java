package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean asK;
    private boolean asL;
    private boolean asM;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.asK = true;
        this.asL = false;
        this.asM = false;
        this.procType = 0;
        this.asK = z;
        this.asL = z2;
        this.asM = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
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
        return this.asK;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zV() {
        return this.asM;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return this.asL;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
        return this.procType;
    }
}
