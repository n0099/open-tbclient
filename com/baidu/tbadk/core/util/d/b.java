package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b extends a {
    private boolean atn;
    private boolean ato;
    private boolean atp;
    private int procType;
    private float scale = 0.43f;
    private int width;

    public b(boolean z, boolean z2, boolean z3, int i) {
        this.width = 0;
        this.atn = true;
        this.ato = false;
        this.atp = false;
        this.procType = 0;
        this.atn = z;
        this.ato = z2;
        this.atp = z3;
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
        return this.atn;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ak() {
        return this.atp;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Al() {
        return this.ato;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Am() {
        return this.procType;
    }
}
