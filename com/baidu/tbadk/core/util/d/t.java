package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean aZj;
    private int procType;

    public t(boolean z, int i) {
        this.aZj = true;
        this.procType = 0;
        this.aZj = z;
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
        return this.aZj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DK() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DL() {
        return this.procType;
    }
}
