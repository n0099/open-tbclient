package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class t extends a {
    private boolean ajr;
    private boolean emw;
    private boolean emx;
    private int height;
    private int procType;
    private int width;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.ajr = true;
        this.emw = false;
        this.emx = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ajr = z;
        this.emw = z2;
        this.emx = z3;
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
        return this.ajr;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjI() {
        return this.emx;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjJ() {
        return this.emw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bjK() {
        return this.procType;
    }
}
