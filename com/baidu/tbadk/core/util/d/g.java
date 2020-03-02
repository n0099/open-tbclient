package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean NJ;
    private boolean dbA;
    private boolean dbB;
    private int dbF;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.NJ = true;
        this.dbA = false;
        this.dbB = false;
        this.procType = 0;
        this.dbF = 0;
        this.NJ = z;
        this.dbA = z2;
        this.dbB = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dbF = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dbF > 480) {
            this.dbF = 480;
        }
        if (this.dbF > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dbF = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.dbF;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.dbF;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.NJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGS() {
        return this.dbB;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGT() {
        return this.dbA;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aGU() {
        return this.procType;
    }
}
