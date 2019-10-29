package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class s extends a {
    private boolean HY;
    private boolean clF;
    private boolean clG;
    private int height;
    private int procType;
    private int width;

    public s(boolean z, boolean z2, boolean z3, int i) {
        this.HY = true;
        this.clF = false;
        this.clG = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.HY = z;
        this.clF = z2;
        this.clG = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.HY;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ani() {
        return this.clG;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anj() {
        return this.clF;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ank() {
        return this.procType;
    }
}
