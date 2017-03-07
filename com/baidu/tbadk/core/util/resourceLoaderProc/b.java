package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean ahO;
    private boolean ahP;
    private boolean ahQ;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.ahO = true;
        this.ahP = false;
        this.ahQ = false;
        this.procType = 0;
        this.ahO = z;
        this.ahP = z2;
        this.ahQ = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return (int) (this.width * this.scale);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.ahO;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return this.ahQ;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wg() {
        return this.ahP;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wh() {
        return this.procType;
    }
}
