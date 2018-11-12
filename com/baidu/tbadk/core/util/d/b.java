package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aAQ;
    private boolean aAR;
    private boolean aAS;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aAQ = true;
        this.aAR = false;
        this.aAS = false;
        this.procType = 0;
        this.aAQ = z;
        this.aAR = z2;
        this.aAS = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
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
        return this.aAQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dr() {
        return this.aAS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ds() {
        return this.aAR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dt() {
        return this.procType;
    }
}
