package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean ajk;
    private boolean ajl;
    private boolean ajm;
    private int ajq;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.ajk = true;
        this.ajl = false;
        this.ajm = false;
        this.procType = 0;
        this.ajq = 0;
        this.ajk = z;
        this.ajl = z2;
        this.ajm = z3;
        this.procType = i;
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst());
        this.ajq = ac <= 0 ? 200 : ac;
        if (this.ajq > 480) {
            this.ajq = 480;
        }
        if (this.ajq > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.ajq = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.ajq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.ajq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajk;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return this.ajm;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return this.ajl;
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

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst()));
    }
}
