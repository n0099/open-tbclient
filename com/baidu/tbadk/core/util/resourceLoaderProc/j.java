package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class j extends a {
    private boolean a;

    public j(boolean z) {
        this.a = true;
        this.a = z;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int d() {
        return com.baidu.adp.lib.util.j.b(TbadkApplication.m252getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int e() {
        return com.baidu.adp.lib.util.j.c(TbadkApplication.m252getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return this.a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean h() {
        return false;
    }
}
