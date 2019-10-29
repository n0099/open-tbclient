package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean HY;
    private boolean clF;
    private boolean clG;
    private int clK;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.HY = true;
        this.clF = false;
        this.clG = false;
        this.procType = 0;
        this.clK = 0;
        this.HY = z;
        this.clF = z2;
        this.clG = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.clK = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.clK > 480) {
            this.clK = CameraInterface.DEFAULT_PREVIEW_HEIGHT;
        }
        if (this.clK > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.clK = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.clK;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return this.clK;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.HY;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ani() {
        return this.clG;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anj() {
        return this.clF;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ank() {
        return this.procType;
    }
}
