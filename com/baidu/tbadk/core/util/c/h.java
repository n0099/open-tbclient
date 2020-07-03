package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends a {
    private boolean aik;
    private boolean dWs;
    private boolean dWt;
    private int dWy;
    private int procType;

    public h(boolean z, boolean z2, boolean z3, int i) {
        this.aik = true;
        this.dWs = false;
        this.dWt = false;
        this.procType = 0;
        this.dWy = 0;
        this.aik = z;
        this.dWs = z2;
        this.dWt = z3;
        this.procType = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.dWy = equipmentWidth <= 0 ? 200 : equipmentWidth;
        if (this.dWy > 480) {
            this.dWy = 480;
        }
        if (this.dWy > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.dWy = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.dWy;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.dWy;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aik;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aXi() {
        return this.dWt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aXj() {
        return this.dWs;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aXk() {
        return this.procType;
    }
}
