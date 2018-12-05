package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aEq;
    private boolean aEr;
    private boolean aEs;
    private int aEw;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.aEq = true;
        this.aEr = false;
        this.aEs = false;
        this.procType = 0;
        this.aEw = 0;
        this.aEq = z;
        this.aEr = z2;
        this.aEs = z3;
        this.procType = i;
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        this.aEw = aO <= 0 ? 200 : aO;
        if (this.aEw > 480) {
            this.aEw = 480;
        }
        if (this.aEw > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aEw = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aEw;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap c(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aEw;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aEq;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ev() {
        return this.aEs;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ew() {
        return this.aEr;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ex() {
        return this.procType;
    }
}
