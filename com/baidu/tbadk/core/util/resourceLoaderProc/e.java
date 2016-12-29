package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int aaU;
    private boolean adn;
    private boolean ado;
    private boolean adp;
    private int adr;
    private int ads;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.adn = true;
        this.ado = false;
        this.adp = false;
        this.aaU = 0;
        this.adr = 0;
        this.ads = 0;
        this.adn = z;
        this.ado = z2;
        this.adp = z3;
        this.aaU = i;
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        this.adr = I <= 0 ? 200 : I;
        if (this.adr > 480) {
            this.adr = 480;
        }
        if (this.adr > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.adr = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.ads = (int) (this.adr * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.gn() ? this.adr : this.ads;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.adn;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vO() {
        return this.adp;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vP() {
        return this.ado;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vQ() {
        return this.aaU;
    }
}
