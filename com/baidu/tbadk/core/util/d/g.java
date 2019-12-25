package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean Nf;
    private boolean cXm;
    private boolean cXn;
    private int cXr;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.Nf = true;
        this.cXm = false;
        this.cXn = false;
        this.procType = 0;
        this.cXr = 0;
        this.Nf = z;
        this.cXm = z2;
        this.cXn = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.cXr = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.cXr > 480) {
            this.cXr = 480;
        }
        if (this.cXr > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.cXr = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.cXr;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.cXr;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.Nf;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEl() {
        return this.cXn;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEm() {
        return this.cXm;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEn() {
        return this.procType;
    }
}
