package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class g extends a {
    private boolean asR;
    private boolean asS;
    private boolean asT;
    private int asX;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.asR = true;
        this.asS = false;
        this.asT = false;
        this.procType = 0;
        this.asX = 0;
        this.asR = z;
        this.asS = z2;
        this.asT = z3;
        this.procType = i;
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        this.asX = ah <= 0 ? 200 : ah;
        if (this.asX > 480) {
            this.asX = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.asX > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.asX = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.asX;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.asX;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.asR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Aa() {
        return this.asT;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ab() {
        return this.asS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ac() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.IQ().fe(BitmapHelper.getBitmapSize(bitmap) * 2);
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
