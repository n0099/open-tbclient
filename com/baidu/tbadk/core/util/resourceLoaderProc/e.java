package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int abe;
    private int adA;
    private int adB;
    private boolean adw;
    private boolean adx;
    private boolean ady;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.adw = true;
        this.adx = false;
        this.ady = false;
        this.abe = 0;
        this.adA = 0;
        this.adB = 0;
        this.adw = z;
        this.adx = z2;
        this.ady = z3;
        this.abe = i;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        this.adA = K <= 0 ? 200 : K;
        if (this.adA > 480) {
            this.adA = 480;
        }
        if (this.adA > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.adA = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.adB = (int) (this.adA * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.gn() ? this.adA : this.adB;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.adw;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wa() {
        return this.ady;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wb() {
        return this.adx;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wc() {
        return this.abe;
    }
}
