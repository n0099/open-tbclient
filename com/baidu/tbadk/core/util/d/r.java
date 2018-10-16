package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private boolean aAb;
    private boolean aAc;
    private boolean aAd;
    private int height;
    private int procType;
    private int width;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aAb = true;
        this.aAc = false;
        this.aAd = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aAb = z;
        this.aAc = z2;
        this.aAd = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap b(Bitmap bitmap, int i, int i2) {
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
        return this.aAb;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dk() {
        return this.aAd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dl() {
        return this.aAc;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dm() {
        return this.procType;
    }
}
