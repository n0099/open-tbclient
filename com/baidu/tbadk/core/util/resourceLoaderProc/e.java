package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int abD;
    private boolean adX;
    private boolean adY;
    private boolean adZ;
    private int aeb;
    private int aec;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.adX = true;
        this.adY = false;
        this.adZ = false;
        this.abD = 0;
        this.aeb = 0;
        this.aec = 0;
        this.adX = z;
        this.adY = z2;
        this.adZ = z3;
        this.abD = i;
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst().getApp());
        this.aeb = B <= 0 ? 200 : B;
        if (this.aeb > 480) {
            this.aeb = 480;
        }
        if (this.aeb > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f)) {
            this.aeb = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 320.0f);
        }
        this.aec = (int) (this.aeb * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.jg() ? this.aeb : this.aec;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.adX;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xb() {
        return this.adZ;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xc() {
        return this.adY;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int xd() {
        return this.abD;
    }
}
