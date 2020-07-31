package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean aib;
    private boolean ecN;
    private boolean ecO;
    private int ecT;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.aib = true;
        this.ecN = false;
        this.ecO = false;
        this.procType = 0;
        this.ecT = 0;
        this.aib = z;
        this.ecN = z2;
        this.ecO = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.ecT = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.ecT > 480) {
            this.ecT = 480;
        }
        if (this.ecT > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.ecT = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.ecT;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.ecT;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aib;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbj() {
        return this.ecO;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbk() {
        return this.ecN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bbl() {
        return this.procType;
    }
}
