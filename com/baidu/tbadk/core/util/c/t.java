package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean aib;
    private boolean ecN;
    private boolean ecO;
    private int height;
    private int procType;
    private int width;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.aib = true;
        this.ecN = false;
        this.ecO = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aib = z;
        this.ecN = z2;
        this.ecO = z3;
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
        return this.aib;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbj() {
        return this.ecO;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbk() {
        return this.ecN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bbl() {
        return this.procType;
    }
}
