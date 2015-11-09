package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean acG;
    private boolean acH;
    private boolean acI;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.acG = true;
        this.acH = false;
        this.acI = false;
        this.acG = z;
        this.acH = z2;
        this.acI = z3;
        this.width = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 430.0f);
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
        return this.acG;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return this.acI;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vn() {
        return this.acH;
    }
}
