package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class j extends a {
    private int abe;

    public j(int i) {
        this.abe = i;
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
    public boolean wa() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m9getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fX = com.baidu.tbadk.imageManager.c.Ek().fX(str3);
        if (fX == null) {
            Bitmap cN = av.cN(com.baidu.adp.lib.h.b.g(str2, 0));
            if (cN == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cN, false, str2);
            com.baidu.tbadk.imageManager.c.Ek().c(str3, aVar);
            return aVar;
        }
        return fX;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wc() {
        return this.abe;
    }
}
