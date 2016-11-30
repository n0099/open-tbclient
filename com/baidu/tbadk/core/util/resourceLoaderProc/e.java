package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int abD;
    private boolean adU;
    private boolean adV;
    private boolean adW;
    private int adY;
    private int adZ;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.adU = true;
        this.adV = false;
        this.adW = false;
        this.abD = 0;
        this.adY = 0;
        this.adZ = 0;
        this.adU = z;
        this.adV = z2;
        this.adW = z3;
        this.abD = i;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        this.adY = K <= 0 ? 200 : K;
        if (this.adY > 480) {
            this.adY = 480;
        }
        if (this.adY > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.adY = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.adZ = (int) (this.adY * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.gn() ? this.adY : this.adZ;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.adU;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean we() {
        return this.adW;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return this.adV;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wg() {
        return this.abD;
    }
}
