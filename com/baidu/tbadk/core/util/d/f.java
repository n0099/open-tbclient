package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean akC;
    private boolean akD;
    private boolean akE;
    private int akI;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.akC = true;
        this.akD = false;
        this.akE = false;
        this.procType = 0;
        this.akI = 0;
        this.akC = z;
        this.akD = z2;
        this.akE = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        this.akI = af <= 0 ? 200 : af;
        if (this.akI > 480) {
            this.akI = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.akI > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.akI = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.akI;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.akI;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.akC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wu() {
        return this.akE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wv() {
        return this.akD;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ww() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.EY().eY(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()));
    }
}
