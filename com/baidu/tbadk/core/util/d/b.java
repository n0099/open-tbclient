package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean asR;
    private boolean asS;
    private boolean asT;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.asR = true;
        this.asS = false;
        this.asT = false;
        this.procType = 0;
        this.asR = z;
        this.asS = z2;
        this.asT = z3;
        this.procType = i;
        this.width = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
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
        return this.asR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Aa() {
        return this.asT;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ab() {
        return this.asS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ac() {
        return this.procType;
    }
}
