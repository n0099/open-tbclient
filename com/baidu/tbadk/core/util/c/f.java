package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean aXs;
    private boolean aXt;
    private boolean aXu;
    private int aXy;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.aXs = true;
        this.aXt = false;
        this.aXu = false;
        this.procType = 0;
        this.aXy = 0;
        this.aXs = z;
        this.aXt = z2;
        this.aXu = z3;
        this.procType = i;
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        this.aXy = ao <= 0 ? 200 : ao;
        if (this.aXy > 480) {
            this.aXy = 480;
        }
        if (this.aXy > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aXy = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.aXy;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.aXy;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aXs;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dn() {
        return this.aXu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Do() {
        return this.aXt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dp() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.LP().ia(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst()));
    }
}
