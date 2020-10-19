package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean akj;
    private boolean eBf;
    private boolean eBg;
    private int height;
    private int procType;
    private int width;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.akj = true;
        this.eBf = false;
        this.eBg = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.akj = z;
        this.eBf = z2;
        this.eBg = z3;
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
        return this.akj;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bnn() {
        return this.eBg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bno() {
        return this.eBf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bnp() {
        return this.procType;
    }
}
