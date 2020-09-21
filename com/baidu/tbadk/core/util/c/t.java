package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean ajR;
    private boolean eoT;
    private boolean eoU;
    private int height;
    private int procType;
    private int width;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.ajR = true;
        this.eoT = false;
        this.eoU = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ajR = z;
        this.eoT = z2;
        this.eoU = z3;
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
        return this.ajR;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bkD() {
        return this.eoU;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bkE() {
        return this.eoT;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bkF() {
        return this.procType;
    }
}
