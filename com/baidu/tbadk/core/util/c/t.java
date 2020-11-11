package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean akk;
    private boolean ePq;
    private boolean ePr;
    private int height;
    private int procType;
    private int width;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.akk = true;
        this.ePq = false;
        this.ePr = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.akk = z;
        this.ePq = z2;
        this.ePr = z3;
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
        return this.akk;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean brG() {
        return this.ePr;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean brH() {
        return this.ePq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int brI() {
        return this.procType;
    }
}
