package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private boolean aET;
    private boolean aEU;
    private boolean aEV;
    private int height;
    private int procType;
    private int width;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aET = true;
        this.aEU = false;
        this.aEV = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aET = z;
        this.aEU = z2;
        this.aEV = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap c(Bitmap bitmap, int i, int i2) {
        return bitmap;
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
