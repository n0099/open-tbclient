package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean Xs;
    private boolean Xt;
    private boolean Xu;
    private int Xx;
    private int Xy;

    public f(boolean z, boolean z2, boolean z3) {
        this.Xs = true;
        this.Xt = false;
        this.Xu = false;
        this.Xx = 0;
        this.Xy = 0;
        this.Xs = z;
        this.Xt = z2;
        this.Xu = z3;
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        this.Xx = M <= 0 ? 200 : M;
        if (this.Xx > 480) {
            this.Xx = 480;
        }
        if (this.Xx > com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.Xx = com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.Xy = (int) (this.Xx * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.iY() ? this.Xx : this.Xy;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
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
