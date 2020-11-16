package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean akn;
    private boolean eOu;
    private boolean eOv;
    private int height;
    private int procType;
    private int width;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.akn = true;
        this.eOu = false;
        this.eOv = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.akn = z;
        this.eOu = z2;
        this.eOv = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.akn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bqU() {
        return this.eOv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bqV() {
        return this.eOu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bqW() {
        return this.procType;
    }
}
