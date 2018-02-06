package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean aZj;
    private boolean aZk;
    private boolean aZl;
    private int aZp;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.aZj = true;
        this.aZk = false;
        this.aZl = false;
        this.procType = 0;
        this.aZp = 0;
        this.aZj = z;
        this.aZk = z2;
        this.aZl = z3;
        this.procType = i;
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        this.aZp = ao <= 0 ? 200 : ao;
        if (this.aZp > 480) {
            this.aZp = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.aZp > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aZp = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aZp;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aZp;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aZj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return this.aZl;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DK() {
        return this.aZk;
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

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst()));
    }
}
