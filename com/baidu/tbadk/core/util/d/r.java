package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private boolean XJ;
    private boolean bUD;
    private boolean bUE;
    private int height;
    private int procType;
    private int width;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.XJ = true;
        this.bUD = false;
        this.bUE = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.XJ = z;
        this.bUD = z2;
        this.bUE = z3;
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
        return this.XJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiO() {
        return this.bUE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiP() {
        return this.bUD;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aiQ() {
        return this.procType;
    }
}
