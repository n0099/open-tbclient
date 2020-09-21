package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean ajR;
    private boolean eoT;
    private boolean eoU;
    private int eoZ;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.ajR = true;
        this.eoT = false;
        this.eoU = false;
        this.procType = 0;
        this.eoZ = 0;
        this.ajR = z;
        this.eoT = z2;
        this.eoU = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.eoZ = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.eoZ > 480) {
            this.eoZ = 480;
        }
        if (this.eoZ > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.eoZ = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.eoZ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.eoZ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajR;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bkD() {
        return this.eoU;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bkE() {
        return this.eoT;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bkF() {
        return this.procType;
    }
}
