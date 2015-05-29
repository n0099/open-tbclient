package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean Xs;
    private boolean Xt;
    private boolean Xu;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.Xs = true;
        this.Xt = false;
        this.Xu = false;
        this.Xs = z;
        this.Xt = z2;
        this.Xu = z3;
        this.width = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 430.0f);
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
        return this.Xs;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean ue() {
        return this.Xu;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uf() {
        return this.Xt;
    }
}
