package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class w extends a {
    private boolean atn;
    private int procType;

    public w(boolean z, int i) {
        this.atn = true;
        this.procType = 0;
        this.atn = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.atn;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ak() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Al() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Am() {
        return this.procType;
    }
}
