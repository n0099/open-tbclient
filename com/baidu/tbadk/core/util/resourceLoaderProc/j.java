package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class j extends a {
    private int Xc;

    public j(int i) {
        this.Xc = i;
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
    public boolean uH() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m11getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fM = com.baidu.tbadk.imageManager.c.CH().fM(str3);
        if (fM == null) {
            Bitmap cA = at.cA(com.baidu.adp.lib.h.b.g(str2, 0));
            if (cA == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cA, false, str2);
            com.baidu.tbadk.imageManager.c.CH().c(str3, aVar);
            return aVar;
        }
        return fM;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Xc;
    }
}
