package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aYZ;
    private boolean aZa;
    private boolean aZb;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.aYZ = true;
        this.aZa = false;
        this.aZb = false;
        this.procType = 0;
        this.aYZ = z;
        this.aZa = z2;
        this.aZb = z3;
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
        return this.aYZ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return this.aZb;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DK() {
        return this.aZa;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DL() {
        return this.procType;
    }
}
