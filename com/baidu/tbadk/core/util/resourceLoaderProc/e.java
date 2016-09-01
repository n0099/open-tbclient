package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private int aaR;
    private boolean adl;
    private boolean adm;
    private boolean adn;
    private int adp;
    private int adq;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.adl = true;
        this.adm = false;
        this.adn = false;
        this.aaR = 0;
        this.adp = 0;
        this.adq = 0;
        this.adl = z;
        this.adm = z2;
        this.adn = z3;
        this.aaR = i;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        this.adp = K <= 0 ? 200 : K;
        if (this.adp > 480) {
            this.adp = 480;
        }
        if (this.adp > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.adp = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.adq = (int) (this.adp * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.gn() ? this.adp : this.adq;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.adl;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vM() {
        return this.adn;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vN() {
        return this.adm;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vO() {
        return this.aaR;
    }
}
