package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o extends a {
    private boolean ahv;
    private int procType;

    public o(boolean z, int i) {
        this.ahv = true;
        this.procType = 0;
        this.ahv = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ahv;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vR() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vS() {
        return this.procType;
    }
}
