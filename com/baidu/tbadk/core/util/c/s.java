package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class s extends a {
    private boolean ajn;
    private int procType;

    public s(boolean z, int i) {
        this.ajn = true;
        this.procType = 0;
        this.ajn = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajn;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wa() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wc() {
        return this.procType;
    }
}
