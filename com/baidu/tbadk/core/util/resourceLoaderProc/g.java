package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.content.Context;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    public g(boolean z, boolean z2, boolean z3) {
        this.a = true;
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = Math.min(k.a((Context) TbadkApplication.m252getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.e = (int) (this.d * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int b() {
        return this.d;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int c() {
        return this.e;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean d() {
        return this.a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean e() {
        return this.c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return this.b;
    }
}
