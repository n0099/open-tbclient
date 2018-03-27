package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean aYZ;
    private boolean aZa;
    private boolean aZb;
    private int aZf;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.aYZ = true;
        this.aZa = false;
        this.aZb = false;
        this.procType = 0;
        this.aZf = 0;
        this.aYZ = z;
        this.aZa = z2;
        this.aZb = z3;
        this.procType = i;
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        this.aZf = ao <= 0 ? 200 : ao;
        if (this.aZf > 480) {
            this.aZf = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.aZf > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aZf = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aZf;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aZf;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aYZ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return this.aZb;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DK() {
        return this.aZa;
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
