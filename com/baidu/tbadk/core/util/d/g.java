package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean ZQ;
    private boolean bMR;
    private boolean bMS;
    private int bMW;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.ZQ = true;
        this.bMR = false;
        this.bMS = false;
        this.procType = 0;
        this.bMW = 0;
        this.ZQ = z;
        this.bMR = z2;
        this.bMS = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.bMW = aO <= 0 ? 200 : aO;
        if (this.bMW > 480) {
            this.bMW = 480;
        }
        if (this.bMW > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bMW = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.bMW;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.bMW;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.ZQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adP() {
        return this.bMS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adQ() {
        return this.bMR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adR() {
        return this.procType;
    }
}
