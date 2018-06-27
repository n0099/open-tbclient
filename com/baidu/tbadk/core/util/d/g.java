package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class g extends a {
    private boolean atn;
    private boolean ato;
    private boolean atp;
    private int att;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.atn = true;
        this.ato = false;
        this.atp = false;
        this.procType = 0;
        this.att = 0;
        this.atn = z;
        this.ato = z2;
        this.atp = z3;
        this.procType = i;
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        this.att = ah <= 0 ? 200 : ah;
        if (this.att > 480) {
            this.att = com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        if (this.att > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.att = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.att;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.att;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.atn;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ak() {
        return this.atp;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Al() {
        return this.ato;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Am() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.IV().fd(BitmapHelper.getBitmapSize(bitmap) * 2);
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
