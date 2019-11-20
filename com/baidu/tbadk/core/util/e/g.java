package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean Hx;
    private boolean ckO;
    private boolean ckP;
    private int ckT;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.Hx = true;
        this.ckO = false;
        this.ckP = false;
        this.procType = 0;
        this.ckT = 0;
        this.Hx = z;
        this.ckO = z2;
        this.ckP = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.ckT = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.ckT > 480) {
            this.ckT = CameraInterface.DEFAULT_PREVIEW_HEIGHT;
        }
        if (this.ckT > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.ckT = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.ckT;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return this.ckT;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.Hx;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ang() {
        return this.ckP;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anh() {
        return this.ckO;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ani() {
        return this.procType;
    }
}
