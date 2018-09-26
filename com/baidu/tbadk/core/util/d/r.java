package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private boolean avq;
    private boolean avr;
    private boolean avs;
    private int height;
    private int procType;
    private int width;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.avq = true;
        this.avr = false;
        this.avs = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.avq = z;
        this.avr = z2;
        this.avs = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.avq;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Bd() {
        return this.avs;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Be() {
        return this.avr;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Bf() {
        return this.procType;
    }
}
