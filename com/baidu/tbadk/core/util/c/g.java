package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean NJ;
    private boolean dbN;
    private boolean dbO;
    private int dbS;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.NJ = true;
        this.dbN = false;
        this.dbO = false;
        this.procType = 0;
        this.dbS = 0;
        this.NJ = z;
        this.dbN = z2;
        this.dbO = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dbS = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dbS > 480) {
            this.dbS = 480;
        }
        if (this.dbS > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dbS = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.dbS;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.dbS;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.NJ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aGT() {
        return this.dbO;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aGU() {
        return this.dbN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aGV() {
        return this.procType;
    }
}
