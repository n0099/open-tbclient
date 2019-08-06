package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean Yd;
    private boolean bVL;
    private boolean bVM;
    private int bVQ;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.Yd = true;
        this.bVL = false;
        this.bVM = false;
        this.procType = 0;
        this.bVQ = 0;
        this.Yd = z;
        this.bVL = z2;
        this.bVM = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        this.bVQ = af <= 0 ? 200 : af;
        if (this.bVQ > 480) {
            this.bVQ = 480;
        }
        if (this.bVQ > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bVQ = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.bVQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.bVQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajU() {
        return this.bVM;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajV() {
        return this.bVL;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ajW() {
        return this.procType;
    }
}
