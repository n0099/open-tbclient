package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aZj;
    private boolean aZk;
    private boolean aZl;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aZj = true;
        this.aZk = false;
        this.aZl = false;
        this.procType = 0;
        this.aZj = z;
        this.aZk = z2;
        this.aZl = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
        if (this.width <= 0 || this.width > 644) {
            this.width = 644;
        }
        if (this.width > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
            this.width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return (int) (this.width * this.scale);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aZj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return this.aZl;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DK() {
        return this.aZk;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DL() {
        return this.procType;
    }
}
