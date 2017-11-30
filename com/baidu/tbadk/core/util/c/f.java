package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean ajn;
    private boolean ajo;
    private boolean ajp;
    private int ajt;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.ajn = true;
        this.ajo = false;
        this.ajp = false;
        this.procType = 0;
        this.ajt = 0;
        this.ajn = z;
        this.ajo = z2;
        this.ajp = z3;
        this.procType = i;
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst());
        this.ajt = ac <= 0 ? 200 : ac;
        if (this.ajt > 480) {
            this.ajt = 480;
        }
        if (this.ajt > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.ajt = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.ajt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.ajt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wa() {
        return this.ajp;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wb() {
        return this.ajo;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wc() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Ez().fg(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }
}
