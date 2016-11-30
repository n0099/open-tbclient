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
    public boolean we() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m9getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a ga = com.baidu.tbadk.imageManager.c.Ep().ga(str3);
        if (ga == null) {
            Bitmap cO = at.cO(com.baidu.adp.lib.h.b.g(str2, 0));
            if (cO == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cO, false, str2);
            com.baidu.tbadk.imageManager.c.Ep().c(str3, aVar);
            return aVar;
        }
        return ga;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wg() {
        return this.abD;
    }
}
