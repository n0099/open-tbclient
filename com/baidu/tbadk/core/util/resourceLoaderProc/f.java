package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean Lg;
    private boolean Lh;
    private boolean Li;
    private int Ll;
    private int Lm;

    public f(boolean z, boolean z2, boolean z3) {
        this.Lg = true;
        this.Lh = false;
        this.Li = false;
        this.Ll = 0;
        this.Lm = 0;
        this.Lg = z;
        this.Lh = z2;
        this.Li = z3;
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        this.Ll = M <= 0 ? 200 : M;
        if (this.Ll > 480) {
            this.Ll = 480;
        }
        if (this.Ll > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 320.0f)) {
            this.Ll = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 320.0f);
        }
        this.Lm = (int) (this.Ll * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.fg() ? this.Ll : this.Lm;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.Lg;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qq() {
        return this.Li;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qr() {
        return this.Lh;
    }
}
