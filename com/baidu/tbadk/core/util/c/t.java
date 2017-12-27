package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean aXt;
    private int procType;

    public t(boolean z, int i) {
        this.aXt = true;
        this.procType = 0;
        this.aXt = z;
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
        return this.aXt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dw() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dx() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dy() {
        return this.procType;
    }
}
