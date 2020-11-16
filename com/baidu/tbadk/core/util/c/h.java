package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean akn;
    private int eOA;
    private boolean eOu;
    private boolean eOv;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.akn = true;
        this.eOu = false;
        this.eOv = false;
        this.procType = 0;
        this.eOA = 0;
        this.akn = z;
        this.eOu = z2;
        this.eOv = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.eOA = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.eOA > 480) {
            this.eOA = 480;
        }
        if (this.eOA > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.eOA = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.eOA;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.eOA;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.akn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bqU() {
        return this.eOv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bqV() {
        return this.eOu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bqW() {
        return this.procType;
    }
}
