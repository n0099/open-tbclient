package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aha;
    private boolean dPA;
    private boolean dPB;
    private int dPF;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.aha = true;
        this.dPA = false;
        this.dPB = false;
        this.procType = 0;
        this.dPF = 0;
        this.aha = z;
        this.dPA = z2;
        this.dPB = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dPF = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dPF > 480) {
            this.dPF = 480;
        }
        if (this.dPF > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dPF = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.dPF;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.dPF;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aha;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aVn() {
        return this.dPB;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aVo() {
        return this.dPA;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aVp() {
        return this.procType;
    }
}
