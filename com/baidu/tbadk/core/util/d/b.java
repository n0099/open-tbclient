package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aEr;
    private boolean aEs;
    private boolean aEt;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aEr = true;
        this.aEs = false;
        this.aEt = false;
        this.procType = 0;
        this.aEr = z;
        this.aEs = z2;
        this.aEt = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
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
        return this.aEr;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ev() {
        return this.aEt;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ew() {
        return this.aEs;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ex() {
        return this.procType;
    }
}
