package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class q extends a {
    private boolean aYZ;
    private boolean aZa;
    private boolean aZb;
    private int height;
    private int procType;
    private int width;

    public q(boolean z, boolean z2, boolean z3, int i) {
        this.aYZ = true;
        this.aZa = false;
        this.aZb = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.aYZ = z;
        this.aZa = z2;
        this.aZb = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
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
        return this.aYZ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return this.aZb;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DK() {
        return this.aZa;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DL() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Mx().hY(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }
}
