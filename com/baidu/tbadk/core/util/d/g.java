package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aAQ;
    private boolean aAR;
    private boolean aAS;
    private int aAW;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.aAQ = true;
        this.aAR = false;
        this.aAS = false;
        this.procType = 0;
        this.aAW = 0;
        this.aAQ = z;
        this.aAR = z2;
        this.aAS = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.aAW = aO <= 0 ? 200 : aO;
        if (this.aAW > 480) {
            this.aAW = 480;
        }
        if (this.aAW > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aAW = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aAW;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap c(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aAW;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aAQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dr() {
        return this.aAS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ds() {
        return this.aAR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dt() {
        return this.procType;
    }
}
