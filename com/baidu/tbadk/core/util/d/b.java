package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean asS;
    private boolean asT;
    private boolean asU;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.asS = true;
        this.asT = false;
        this.asU = false;
        this.procType = 0;
        this.asS = z;
        this.asT = z2;
        this.asU = z3;
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
        return this.asS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zY() {
        return this.asU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zZ() {
        return this.asT;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Aa() {
        return this.procType;
    }
}
