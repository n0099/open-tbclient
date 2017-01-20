package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class j extends a {
    private int procType;

    public j(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m9getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.DS().fT(str3);
        if (fT == null) {
            Bitmap cP = ap.cP(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cP == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cP, false, str2);
            com.baidu.tbadk.imageManager.c.DS().c(str3, aVar);
            return aVar;
        }
        return fT;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vK() {
        return this.procType;
    }
}
