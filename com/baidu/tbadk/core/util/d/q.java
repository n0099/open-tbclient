package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class q extends a {
    private boolean aXA;
    private boolean aXB;
    private boolean aXC;
    private int height;
    private int procType;
    private int width;

    public q(boolean z, boolean z2, boolean z3, int i) {
        this.aXA = true;
        this.aXB = false;
        this.aXC = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aXA = z;
        this.aXB = z2;
        this.aXC = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.height = (int) (this.width * 1.6f);
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
        return this.aXA;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dp() {
        return this.aXC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dq() {
        return this.aXB;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dr() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.LR().ia(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }
}
