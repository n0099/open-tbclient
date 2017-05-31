package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean ahm;
    private boolean ahn;
    private boolean aho;
    private int ahq;
    private int ahr;
    private int procType;

    public e(boolean z, boolean z2, boolean z3, int i) {
        this.ahm = true;
        this.ahn = false;
        this.aho = false;
        this.procType = 0;
        this.ahq = 0;
        this.ahr = 0;
        this.ahm = z;
        this.ahn = z2;
        this.aho = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        this.ahq = af <= 0 ? 200 : af;
        if (this.ahq > 480) {
            this.ahq = 480;
        }
        if (this.ahq > com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f)) {
            this.ahq = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 320.0f);
        }
        this.ahr = (int) (this.ahq * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.hl() ? this.ahq : this.ahr;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ahm;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vN() {
        return this.aho;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vO() {
        return this.ahn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vP() {
        return this.procType;
    }
}
