package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean aXs;
    private int procType;

    public t(boolean z, int i) {
        this.aXs = true;
        this.procType = 0;
        this.aXs = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aXs;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Do() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dp() {
        return this.procType;
    }
}
