package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aEr;
    private boolean aEs;
    private boolean aEt;
    private int aEx;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.aEr = true;
        this.aEs = false;
        this.aEt = false;
        this.procType = 0;
        this.aEx = 0;
        this.aEr = z;
        this.aEs = z2;
        this.aEt = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.aEx = aO <= 0 ? 200 : aO;
        if (this.aEx > 480) {
            this.aEx = 480;
        }
        if (this.aEx > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aEx = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aEx;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap c(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aEx;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aEr;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ev() {
        return this.aEt;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ew() {
        return this.aEs;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ex() {
        return this.procType;
    }
}
