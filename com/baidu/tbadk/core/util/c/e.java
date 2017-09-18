package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean aje;
    private boolean ajf;
    private boolean ajg;
    private int aji;
    private int ajj;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.aje = true;
        this.ajf = false;
        this.ajg = false;
        this.procType = 0;
        this.aji = 0;
        this.ajj = 0;
        this.aje = z;
        this.ajf = z2;
        this.ajg = z3;
        this.procType = i;
        int ae = com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getApp());
        this.aji = ae <= 0 ? 200 : ae;
        if (this.aji > 480) {
            this.aji = 480;
        }
        if (this.aji > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f)) {
            this.aji = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 320.0f);
        }
        this.ajj = (int) (this.aji * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hj() ? this.aji : this.ajj;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aje;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ws() {
        return this.ajg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wt() {
        return this.ajf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wu() {
        return this.procType;
    }
}
