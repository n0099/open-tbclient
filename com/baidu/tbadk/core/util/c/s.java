package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class s extends a {
    private boolean agt;
    private boolean dBp;
    private boolean dBq;
    private int height;
    private int procType;
    private int width;

    public s(boolean z, boolean z2, boolean z3, int i) {
        this.agt = true;
        this.dBp = false;
        this.dBq = false;
        this.procType = 0;
        this.width = 0;
        this.height = 0;
        this.agt = z;
        this.dBp = z2;
        this.dBq = z3;
        this.procType = i;
        this.width = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
        this.height = (int) (this.width * 1.6f);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.agt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aPm() {
        return this.dBq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aPn() {
        return this.dBp;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aPo() {
        return this.procType;
    }
}
