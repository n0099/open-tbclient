package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class r extends a {
    private boolean asS;
    private boolean asT;
    private boolean asU;
    private int height;
    private int procType;
    private int width;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.asS = true;
        this.asT = false;
        this.asU = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.asS = z;
        this.asT = z2;
        this.asU = z3;
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
        return this.asS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zY() {
        return this.asU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zZ() {
        return this.asT;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Aa() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.IQ().fd(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }
}
