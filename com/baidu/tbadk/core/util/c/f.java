package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean aXt;
    private boolean aXu;
    private boolean aXv;
    private int aXz;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.aXt = true;
        this.aXu = false;
        this.aXv = false;
        this.procType = 0;
        this.aXz = 0;
        this.aXt = z;
        this.aXu = z2;
        this.aXv = z3;
        this.procType = i;
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        this.aXz = ao <= 0 ? 200 : ao;
        if (this.aXz > 480) {
            this.aXz = 480;
        }
        if (this.aXz > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aXz = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.aXz;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.aXz;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aXt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dw() {
        return this.aXv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dx() {
        return this.aXu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dy() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Mb().ie(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst()));
    }
}
