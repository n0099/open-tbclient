package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean aik;
    private boolean dWs;
    private boolean dWt;
    private int height;
    private int procType;
    private int width;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.aik = true;
        this.dWs = false;
        this.dWt = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aik = z;
        this.dWs = z2;
        this.dWt = z3;
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
        return this.aik;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aXi() {
        return this.dWt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aXj() {
        return this.dWs;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aXk() {
        return this.procType;
    }
}
