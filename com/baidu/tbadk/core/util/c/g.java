package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean agt;
    private boolean dBp;
    private boolean dBq;
    private int dBu;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.agt = true;
        this.dBp = false;
        this.dBq = false;
        this.procType = 0;
        this.dBu = 0;
        this.agt = z;
        this.dBp = z2;
        this.dBq = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dBu = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dBu > 480) {
            this.dBu = 480;
        }
        if (this.dBu > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dBu = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.dBu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.dBu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.agt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aPm() {
        return this.dBq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aPn() {
        return this.dBp;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aPo() {
        return this.procType;
    }
}
