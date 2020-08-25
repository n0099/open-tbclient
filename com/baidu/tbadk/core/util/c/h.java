package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class h extends a {
    private boolean ajr;
    private int emC;
    private boolean emw;
    private boolean emx;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.ajr = true;
        this.emw = false;
        this.emx = false;
        this.procType = 0;
        this.emC = 0;
        this.ajr = z;
        this.emw = z2;
        this.emx = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.emC = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.emC > 480) {
            this.emC = 480;
        }
        if (this.emC > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.emC = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.emC;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.emC;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajr;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjI() {
        return this.emx;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjJ() {
        return this.emw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bjK() {
        return this.procType;
    }
}
