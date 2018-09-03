package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class g extends a {
    private boolean asS;
    private boolean asT;
    private boolean asU;
    private int asY;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.asS = true;
        this.asT = false;
        this.asU = false;
        this.procType = 0;
        this.asY = 0;
        this.asS = z;
        this.asT = z2;
        this.asU = z3;
        this.procType = i;
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        this.asY = ah <= 0 ? 200 : ah;
        if (this.asY > 480) {
            this.asY = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.asY > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.asY = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.asY;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.asY;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.asS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zY() {
        return this.asU;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zZ() {
        return this.asT;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Aa() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.IQ().fd(BitmapHelper.getBitmapSize(bitmap) * 2);
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
