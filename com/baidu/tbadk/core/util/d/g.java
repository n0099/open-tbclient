package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aEU;
    private boolean aEV;
    private boolean aEW;
    private int aFa;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.aEU = true;
        this.aEV = false;
        this.aEW = false;
        this.procType = 0;
        this.aFa = 0;
        this.aEU = z;
        this.aEV = z2;
        this.aEW = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.aFa = aO <= 0 ? 200 : aO;
        if (this.aFa > 480) {
            this.aFa = 480;
        }
        if (this.aFa > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aFa = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aFa;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap c(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aFa;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aEU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean EI() {
        return this.aEW;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean EJ() {
        return this.aEV;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int EK() {
        return this.procType;
    }
}
