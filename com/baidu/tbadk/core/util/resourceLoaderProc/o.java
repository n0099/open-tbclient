package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o extends a {
    private boolean acB;

    public o(boolean z) {
        this.acB = true;
        this.acB = z;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.acB;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vi() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vj() {
        return false;
    }
}
