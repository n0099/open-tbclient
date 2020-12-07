package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean alo;
    private boolean eVJ;
    private boolean eVK;
    private int eVP;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.alo = true;
        this.eVJ = false;
        this.eVK = false;
        this.procType = 0;
        this.eVP = 0;
        this.alo = z;
        this.eVJ = z2;
        this.eVK = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.eVP = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.eVP > 480) {
            this.eVP = 480;
        }
        if (this.eVP > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.eVP = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.eVP;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.eVP;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.alo;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bur() {
        return this.eVK;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bus() {
        return this.eVJ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int but() {
        return this.procType;
    }
}
