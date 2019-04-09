package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean ZR;
    private boolean bMS;
    private boolean bMT;
    private int bMX;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.ZR = true;
        this.bMS = false;
        this.bMT = false;
        this.procType = 0;
        this.bMX = 0;
        this.ZR = z;
        this.bMS = z2;
        this.bMT = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.bMX = aO <= 0 ? 200 : aO;
        if (this.bMX > 480) {
            this.bMX = 480;
        }
        if (this.bMX > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bMX = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.bMX;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.bMX;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.ZR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adP() {
        return this.bMT;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adQ() {
        return this.bMS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adR() {
        return this.procType;
    }
}
