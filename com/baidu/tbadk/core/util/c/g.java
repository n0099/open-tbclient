package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean agw;
    private boolean dBt;
    private boolean dBu;
    private int dBy;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.agw = true;
        this.dBt = false;
        this.dBu = false;
        this.procType = 0;
        this.dBy = 0;
        this.agw = z;
        this.dBt = z2;
        this.dBu = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dBy = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dBy > 480) {
            this.dBy = 480;
        }
        if (this.dBy > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dBy = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.dBy;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.dBy;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.agw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aPj() {
        return this.dBu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aPk() {
        return this.dBt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aPl() {
        return this.procType;
    }
}
