package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean Ld;
    private boolean Le;
    private boolean Lf;
    private int Li;
    private int Lj;

    public f(boolean z, boolean z2, boolean z3) {
        this.Ld = true;
        this.Le = false;
        this.Lf = false;
        this.Li = 0;
        this.Lj = 0;
        this.Ld = z;
        this.Le = z2;
        this.Lf = z3;
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        this.Li = M <= 0 ? 200 : M;
        if (this.Li > 480) {
            this.Li = 480;
        }
        if (this.Li > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 320.0f)) {
            this.Li = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 320.0f);
        }
        this.Lj = (int) (this.Li * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.fg() ? this.Li : this.Lj;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.Ld;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qj() {
        return this.Lf;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qk() {
        return this.Le;
    }
}
