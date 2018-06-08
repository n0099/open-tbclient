package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class v extends a {
    private boolean asK;
    private int procType;

    public v(boolean z, int i) {
        this.asK = true;
        this.procType = 0;
        this.asK = z;
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
        return this.asK;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zV() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
        return this.procType;
    }
}
