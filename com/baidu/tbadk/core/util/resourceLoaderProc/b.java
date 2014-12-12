package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean KM;
    private boolean KN;
    private boolean KO;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.KM = true;
        this.KN = false;
        this.KO = false;
        this.KM = z;
        this.KN = z2;
        this.KO = z3;
        this.width = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 430.0f);
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
        return this.KM;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qf() {
        return this.KO;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qg() {
        return this.KN;
    }
}
