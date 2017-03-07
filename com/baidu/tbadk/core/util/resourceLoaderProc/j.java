package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
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
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m9getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fI = com.baidu.tbadk.imageManager.c.El().fI(str3);
        if (fI == null) {
            Bitmap cL = aq.cL(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cL == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cL, false, str2);
            com.baidu.tbadk.imageManager.c.El().c(str3, aVar);
            return aVar;
        }
        return fI;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wh() {
        return this.procType;
    }
}
