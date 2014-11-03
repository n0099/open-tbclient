package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class b extends a {
    private float GC = 0.43f;
    private boolean GD;
    private boolean GE;
    private boolean GF;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.GD = true;
        this.GE = false;
        this.GF = false;
        this.GD = z;
        this.GE = z2;
        this.GF = z3;
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
        return (int) (this.width * this.GC);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.GD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return this.GF;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return this.GE;
    }
}
