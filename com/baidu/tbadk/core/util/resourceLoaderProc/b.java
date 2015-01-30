package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean Lg;
    private boolean Lh;
    private boolean Li;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3) {
        this.width = 0;
        this.Lg = true;
        this.Lh = false;
        this.Li = false;
        this.Lg = z;
        this.Lh = z2;
        this.Li = z3;
        this.width = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 430.0f);
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
