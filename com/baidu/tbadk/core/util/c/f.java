package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean ajh;
    private boolean aji;
    private boolean ajj;
    private int ajn;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.ajh = true;
        this.aji = false;
        this.ajj = false;
        this.procType = 0;
        this.ajn = 0;
        this.ajh = z;
        this.aji = z2;
        this.ajj = z3;
        this.procType = i;
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst());
        this.ajn = ac <= 0 ? 200 : ac;
        if (this.ajn > 480) {
            this.ajn = 480;
        }
        if (this.ajn > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.ajn = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.ajn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.ajn;
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

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst()));
    }
}
