package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends a {
    private boolean asK;
    private boolean asL;
    private boolean asM;
    private int asQ;
    private int procType;

    public f(boolean z, boolean z2, boolean z3, int i) {
        this.asK = true;
        this.asL = false;
        this.asM = false;
        this.procType = 0;
        this.asQ = 0;
        this.asK = z;
        this.asL = z2;
        this.asM = z3;
        this.procType = i;
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        this.asQ = ah <= 0 ? 200 : ah;
        if (this.asQ > 480) {
            this.asQ = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.asQ > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.asQ = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.asQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.asQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.asK;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zV() {
        return this.asM;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return this.asL;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.ID().fc(BitmapHelper.getBitmapSize(bitmap) * 2);
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst()));
    }
}
