package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o extends a {
    private boolean ahm;
    private int procType;

    public o(boolean z, int i) {
        this.ahm = true;
        this.procType = 0;
        this.ahm = z;
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
        return this.ahm;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vO() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vP() {
        return this.procType;
    }
}
