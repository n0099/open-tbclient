package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o extends a {
    private boolean aiq;
    private int procType;

    public o(boolean z, int i) {
        this.aiq = true;
        this.procType = 0;
        this.aiq = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aiq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wm() {
        return this.procType;
    }
}
