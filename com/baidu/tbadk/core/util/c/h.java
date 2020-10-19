package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean akj;
    private boolean eBf;
    private boolean eBg;
    private int eBl;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.akj = true;
        this.eBf = false;
        this.eBg = false;
        this.procType = 0;
        this.eBl = 0;
        this.akj = z;
        this.eBf = z2;
        this.eBg = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.eBl = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.eBl > 480) {
            this.eBl = 480;
        }
        if (this.eBl > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.eBl = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.eBl;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.eBl;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.akj;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bnn() {
        return this.eBg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bno() {
        return this.eBf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bnp() {
        return this.procType;
    }
}
