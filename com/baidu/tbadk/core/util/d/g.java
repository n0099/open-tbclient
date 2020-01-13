package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean Nj;
    private int cXB;
    private boolean cXw;
    private boolean cXx;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.Nj = true;
        this.cXw = false;
        this.cXx = false;
        this.procType = 0;
        this.cXB = 0;
        this.Nj = z;
        this.cXw = z2;
        this.cXx = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.cXB = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.cXB > 480) {
            this.cXB = 480;
        }
        if (this.cXB > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.cXB = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.cXB;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.cXB;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.Nj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEE() {
        return this.cXx;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEF() {
        return this.cXw;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEG() {
        return this.procType;
    }
}
