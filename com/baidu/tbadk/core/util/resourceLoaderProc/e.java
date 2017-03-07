package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean ahO;
    private boolean ahP;
    private boolean ahQ;
    private int ahS;
    private int ahT;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ahO = true;
        this.ahP = false;
        this.ahQ = false;
        this.procType = 0;
        this.ahS = 0;
        this.ahT = 0;
        this.ahO = z;
        this.ahP = z2;
        this.ahQ = z3;
        this.procType = i;
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        this.ahS = ag <= 0 ? 200 : ag;
        if (this.ahS > 480) {
            this.ahS = 480;
        }
        if (this.ahS > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.ahS = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.ahT = (int) (this.ahS * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hf() ? this.ahS : this.ahT;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
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
