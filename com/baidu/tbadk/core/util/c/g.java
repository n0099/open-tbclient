package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean NK;
    private boolean dca;
    private boolean dcb;
    private int dcf;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.NK = true;
        this.dca = false;
        this.dcb = false;
        this.procType = 0;
        this.dcf = 0;
        this.NK = z;
        this.dca = z2;
        this.dcb = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dcf = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dcf > 480) {
            this.dcf = 480;
        }
        if (this.dcf > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dcf = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.dcf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.dcf;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.NK;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aGX() {
        return this.dcb;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aGY() {
        return this.dca;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aGZ() {
        return this.procType;
    }
}
