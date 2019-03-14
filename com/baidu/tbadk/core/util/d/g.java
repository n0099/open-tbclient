package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean ZP;
    private boolean bMP;
    private boolean bMQ;
    private int bMU;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.ZP = true;
        this.bMP = false;
        this.bMQ = false;
        this.procType = 0;
        this.bMU = 0;
        this.ZP = z;
        this.bMP = z2;
        this.bMQ = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.bMU = aO <= 0 ? 200 : aO;
        if (this.bMU > 480) {
            this.bMU = 480;
        }
        if (this.bMU > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bMU = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.bMU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.bMU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.ZP;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adS() {
        return this.bMQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adT() {
        return this.bMP;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adU() {
        return this.procType;
    }
}
