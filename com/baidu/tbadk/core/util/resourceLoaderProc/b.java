package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean WF;
    private boolean WG;
    private boolean WH;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.WF = true;
        this.WG = false;
        this.WH = false;
        this.WF = z;
        this.WG = z2;
        this.WH = z3;
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
        return this.WF;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tz() {
        return this.WH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tA() {
        return this.WG;
    }
}
