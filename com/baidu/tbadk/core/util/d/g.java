package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean XJ;
    private boolean bUD;
    private boolean bUE;
    private int bUI;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.XJ = true;
        this.bUD = false;
        this.bUE = false;
        this.procType = 0;
        this.bUI = 0;
        this.XJ = z;
        this.bUD = z2;
        this.bUE = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        this.bUI = af <= 0 ? 200 : af;
        if (this.bUI > 480) {
            this.bUI = 480;
        }
        if (this.bUI > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bUI = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.bUI;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.bUI;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.XJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiO() {
        return this.bUE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiP() {
        return this.bUD;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aiQ() {
        return this.procType;
    }
}
