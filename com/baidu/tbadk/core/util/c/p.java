package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class p extends a {
    private boolean aiu;
    private int procType;

    public p(boolean z, int i) {
        this.aiu = true;
        this.procType = 0;
        this.aiu = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aiu;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vR() {
        return this.procType;
    }
}
