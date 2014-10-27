package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class b extends a {
    private float GB = 0.43f;
    private boolean GC;
    private boolean GD;
    private boolean GE;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.GC = true;
        this.GD = false;
        this.GE = false;
        this.GC = z;
        this.GD = z2;
        this.GE = z3;
        this.width = com.baidu.adp.lib.util.m.n(TbadkApplication.m251getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return (int) (this.width * this.GB);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.GC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return this.GE;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return this.GD;
    }
}
