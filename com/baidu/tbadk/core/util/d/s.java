package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class s extends a {
    private boolean Nf;
    private boolean cXm;
    private boolean cXn;
    private int height;
    private int procType;
    private int width;

    public s(boolean z, boolean z2, boolean z3, int i) {
        this.Nf = true;
        this.cXm = false;
        this.cXn = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.Nf = z;
        this.cXm = z2;
        this.cXn = z3;
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
        return this.Nf;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEl() {
        return this.cXn;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEm() {
        return this.cXm;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEn() {
        return this.procType;
    }
}
