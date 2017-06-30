package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o extends a {
    private boolean ahU;
    private int procType;

    public o(boolean z, int i) {
        this.ahU = true;
        this.procType = 0;
        this.ahU = z;
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
        return this.ahU;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean we() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wg() {
        return this.procType;
    }
}
