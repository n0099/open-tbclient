package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean akk;
    private boolean eJB;
    private boolean eJC;
    private int eJH;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.akk = true;
        this.eJB = false;
        this.eJC = false;
        this.procType = 0;
        this.eJH = 0;
        this.akk = z;
        this.eJB = z2;
        this.eJC = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.eJH = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.eJH > 480) {
            this.eJH = 480;
        }
        if (this.eJH > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.eJH = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.eJH;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.eJH;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.akk;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bpg() {
        return this.eJC;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bph() {
        return this.eJB;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bpi() {
        return this.procType;
    }
}
