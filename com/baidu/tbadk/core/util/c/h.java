package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean ajt;
    private boolean emA;
    private boolean emB;
    private int emG;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.ajt = true;
        this.emA = false;
        this.emB = false;
        this.procType = 0;
        this.emG = 0;
        this.ajt = z;
        this.emA = z2;
        this.emB = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.emG = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.emG > 480) {
            this.emG = 480;
        }
        if (this.emG > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.emG = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.emG;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.emG;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjI() {
        return this.emB;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjJ() {
        return this.emA;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bjK() {
        return this.procType;
    }
}
