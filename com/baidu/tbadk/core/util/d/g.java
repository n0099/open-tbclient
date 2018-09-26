package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean avq;
    private boolean avr;
    private boolean avs;
    private int avw;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.avq = true;
        this.avr = false;
        this.avs = false;
        this.procType = 0;
        this.avw = 0;
        this.avq = z;
        this.avr = z2;
        this.avs = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.avw = aO <= 0 ? 200 : aO;
        if (this.avw > 480) {
            this.avw = 480;
        }
        if (this.avw > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.avw = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.avw;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.avw;
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
