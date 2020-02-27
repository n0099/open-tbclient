package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean NJ;
    private boolean dbA;
    private int dbE;
    private boolean dbz;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.NJ = true;
        this.dbz = false;
        this.dbA = false;
        this.procType = 0;
        this.dbE = 0;
        this.NJ = z;
        this.dbz = z2;
        this.dbA = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dbE = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dbE > 480) {
            this.dbE = 480;
        }
        if (this.dbE > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dbE = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.dbE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.dbE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.NJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGQ() {
        return this.dbA;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGR() {
        return this.dbz;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aGS() {
        return this.procType;
    }
}
