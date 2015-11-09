package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private boolean acG;

    public n(boolean z) {
        this.acG = true;
        this.acG = z;
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
        return this.acG;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vn() {
        return false;
    }
}
