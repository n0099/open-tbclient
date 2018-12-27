package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private boolean aEr;
    private boolean aEs;
    private boolean aEt;
    private int height;
    private int procType;
    private int width;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aEr = true;
        this.aEs = false;
        this.aEt = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aEr = z;
        this.aEs = z2;
        this.aEt = z3;
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
