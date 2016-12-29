package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private int aaU;
    private boolean adn;
    private boolean ado;
    private boolean adp;
    private int height;
    private int width;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.adn = true;
        this.ado = false;
        this.adp = false;
        this.aaU = 0;
        this.width = 0;
        this.height = 0;
        this.adn = z;
        this.ado = z2;
        this.adp = z3;
        this.aaU = i;
        this.width = Math.min(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return this.height;
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
