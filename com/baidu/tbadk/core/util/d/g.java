package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean Yd;
    private boolean bVF;
    private boolean bVG;
    private int bVK;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.Yd = true;
        this.bVF = false;
        this.bVG = false;
        this.procType = 0;
        this.bVK = 0;
        this.Yd = z;
        this.bVF = z2;
        this.bVG = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        this.bVK = af <= 0 ? 200 : af;
        if (this.bVK > 480) {
            this.bVK = 480;
        }
        if (this.bVK > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bVK = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.bVK;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.bVK;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajS() {
        return this.bVG;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajT() {
        return this.bVF;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ajU() {
        return this.procType;
    }
}
