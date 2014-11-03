package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class o extends a {
    private boolean GD;

    public o(boolean z) {
        this.GD = true;
        this.GD = z;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.m.n(TbadkApplication.m251getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.m.o(TbadkApplication.m251getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.GD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return false;
    }
}
