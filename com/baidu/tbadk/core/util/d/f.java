package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean aXA;
    private boolean aXB;
    private boolean aXC;
    private int aXG;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.aXA = true;
        this.aXB = false;
        this.aXC = false;
        this.procType = 0;
        this.aXG = 0;
        this.aXA = z;
        this.aXB = z2;
        this.aXC = z3;
        this.procType = i;
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        this.aXG = ao <= 0 ? 200 : ao;
        if (this.aXG > 480) {
            this.aXG = 480;
        }
        if (this.aXG > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aXG = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aXG;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aXG;
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

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst()));
    }
}
