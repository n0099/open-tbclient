package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private int abe;
    private boolean adw;
    private boolean adx;
    private boolean ady;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.adw = true;
        this.adx = false;
        this.ady = false;
        this.abe = 0;
        this.adw = z;
        this.adx = z2;
        this.ady = z3;
        this.abe = i;
        this.width = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 430.0f);
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
        return this.adw;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wa() {
        return this.ady;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wb() {
        return this.adx;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wc() {
        return this.abe;
    }
}
