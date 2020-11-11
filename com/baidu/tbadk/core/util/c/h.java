package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean akk;
    private boolean ePq;
    private boolean ePr;
    private int ePw;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.akk = true;
        this.ePq = false;
        this.ePr = false;
        this.procType = 0;
        this.ePw = 0;
        this.akk = z;
        this.ePq = z2;
        this.ePr = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.ePw = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.ePw > 480) {
            this.ePw = 480;
        }
        if (this.ePw > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.ePw = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.ePw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.ePw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.akk;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean brG() {
        return this.ePr;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean brH() {
        return this.ePq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int brI() {
        return this.procType;
    }
}
