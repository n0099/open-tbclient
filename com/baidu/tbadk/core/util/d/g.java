package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aET;
    private boolean aEU;
    private boolean aEV;
    private int aEZ;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.aET = true;
        this.aEU = false;
        this.aEV = false;
        this.procType = 0;
        this.aEZ = 0;
        this.aET = z;
        this.aEU = z2;
        this.aEV = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.aEZ = aO <= 0 ? 200 : aO;
        if (this.aEZ > 480) {
            this.aEZ = 480;
        }
        if (this.aEZ > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aEZ = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aEZ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap c(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aEZ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aET;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean EI() {
        return this.aEV;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean EJ() {
        return this.aEU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int EK() {
        return this.procType;
    }
}
