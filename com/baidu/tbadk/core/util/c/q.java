package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class q extends a {
    private boolean ajh;
    private boolean aji;
    private boolean ajj;
    private int height;
    private int procType;
    private int width;

    public q(boolean z, boolean z2, boolean z3, int i) {
        this.ajh = true;
        this.aji = false;
        this.ajj = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.ajh = z;
        this.aji = z2;
        this.ajj = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        this.height = (int) (this.width * 1.6f);
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
        return this.ajh;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return this.ajj;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return this.aji;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.EA().fg(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }
}
