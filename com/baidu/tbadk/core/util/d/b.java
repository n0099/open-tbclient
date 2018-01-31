package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aXA;
    private boolean aXB;
    private boolean aXC;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aXA = true;
        this.aXB = false;
        this.aXC = false;
        this.procType = 0;
        this.aXA = z;
        this.aXB = z2;
        this.aXC = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
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
        return this.aXA;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dp() {
        return this.aXC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dq() {
        return this.aXB;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dr() {
        return this.procType;
    }
}
