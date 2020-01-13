package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class s extends a {
    private boolean Nj;
    private boolean cXw;
    private boolean cXx;
    private int height;
    private int procType;
    private int width;

    public s(boolean z, boolean z2, boolean z3, int i) {
        this.Nj = true;
        this.cXw = false;
        this.cXx = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.Nj = z;
        this.cXw = z2;
        this.cXx = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
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
        return this.Nj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEE() {
        return this.cXx;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEF() {
        return this.cXw;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEG() {
        return this.procType;
    }
}
