package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean aiR;
    private boolean aiS;
    private boolean aiT;
    private int aiX;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.aiR = true;
        this.aiS = false;
        this.aiT = false;
        this.procType = 0;
        this.aiX = 0;
        this.aiR = z;
        this.aiS = z2;
        this.aiT = z3;
        this.procType = i;
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst());
        this.aiX = ac <= 0 ? 200 : ac;
        if (this.aiX > 480) {
            this.aiX = 480;
        }
        if (this.aiX > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aiX = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.aiX;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.aiX;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aiR;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return this.aiT;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return this.aiS;
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
            com.baidu.tbadk.imageManager.c.Es().fh(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }
}
