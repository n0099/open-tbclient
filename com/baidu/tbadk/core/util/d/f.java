package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean aYX;
    private boolean aYY;
    private boolean aYZ;
    private int aZd;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.aYX = true;
        this.aYY = false;
        this.aYZ = false;
        this.procType = 0;
        this.aZd = 0;
        this.aYX = z;
        this.aYY = z2;
        this.aYZ = z3;
        this.procType = i;
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        this.aZd = ao <= 0 ? 200 : ao;
        if (this.aZd > 480) {
            this.aZd = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.aZd > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.aZd = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.aZd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.aZd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aYX;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DI() {
        return this.aYZ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return this.aYY;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DK() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Mw().hY(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst()));
    }
}
