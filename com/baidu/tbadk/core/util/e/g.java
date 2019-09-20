package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean Yd;
    private boolean bWC;
    private boolean bWD;
    private int bWH;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.Yd = true;
        this.bWC = false;
        this.bWD = false;
        this.procType = 0;
        this.bWH = 0;
        this.Yd = z;
        this.bWC = z2;
        this.bWD = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        this.bWH = af <= 0 ? 200 : af;
        if (this.bWH > 480) {
            this.bWH = CameraInterface.DEFAULT_PREVIEW_HEIGHT;
        }
        if (this.bWH > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bWH = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.bWH;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return this.bWH;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akg() {
        return this.bWD;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akh() {
        return this.bWC;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int aki() {
        return this.procType;
    }
}
