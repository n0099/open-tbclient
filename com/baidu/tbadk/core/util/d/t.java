package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean aXA;
    private int procType;

    public t(boolean z, int i) {
        this.aXA = true;
        this.procType = 0;
        this.aXA = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aXA;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dp() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dq() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dr() {
        return this.procType;
    }
}
