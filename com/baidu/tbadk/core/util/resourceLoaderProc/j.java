package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class j extends a {
    private int abD;

    public j(int i) {
        this.abD = i;
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
    public boolean xb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xc() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m411getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fP = com.baidu.tbadk.imageManager.c.EO().fP(str3);
        if (fP == null) {
            Bitmap cR = at.cR(com.baidu.adp.lib.h.b.g(str2, 0));
            if (cR == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cR, false, str2);
            com.baidu.tbadk.imageManager.c.EO().c(str3, aVar);
            return aVar;
        }
        return fP;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int xd() {
        return this.abD;
    }
}
