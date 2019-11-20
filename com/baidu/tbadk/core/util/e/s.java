package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class s extends a {
    private boolean Hx;
    private boolean ckO;
    private boolean ckP;
    private int height;
    private int procType;
    private int width;

    public s(boolean z, boolean z2, boolean z3, int i) {
        this.Hx = true;
        this.ckO = false;
        this.ckP = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.Hx = z;
        this.ckO = z2;
        this.ckP = z3;
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
        return this.Hx;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ang() {
        return this.ckP;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anh() {
        return this.ckO;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ani() {
        return this.procType;
    }
}
