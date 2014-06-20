package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class i extends a {
    private boolean a;

    public i(boolean z) {
        this.a = true;
        this.a = z;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int c() {
        return k.b(TbadkApplication.m252getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int d() {
        return k.c(TbadkApplication.m252getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean e() {
        return this.a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean g() {
        return false;
    }
}
