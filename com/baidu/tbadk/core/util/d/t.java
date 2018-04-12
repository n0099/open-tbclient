package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private boolean akC;
    private int procType;

    public t(boolean z, int i) {
        this.akC = true;
        this.procType = 0;
        this.akC = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.akC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wv() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ww() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int wx() {
        return this.procType;
    }
}
