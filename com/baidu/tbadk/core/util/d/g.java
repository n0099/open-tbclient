package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends a {
    private boolean XI;
    private boolean bUE;
    private boolean bUF;
    private int bUJ;
    private int procType;

    public g(boolean z, boolean z2, boolean z3, int i) {
        this.XI = true;
        this.bUE = false;
        this.bUF = false;
        this.procType = 0;
        this.bUJ = 0;
        this.XI = z;
        this.bUE = z2;
        this.bUF = z3;
        this.procType = i;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        this.bUJ = af <= 0 ? 200 : af;
        if (this.bUJ > 480) {
            this.bUJ = 480;
        }
        if (this.bUJ > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
            this.bUJ = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.bUJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.bUJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.XI;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiO() {
        return this.bUF;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiP() {
        return this.bUE;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aiQ() {
        return this.procType;
    }
}
