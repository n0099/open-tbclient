package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i extends a {
    private int acq;

    public i(int i) {
        this.acq = i;
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
    public boolean wI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m411getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fH = com.baidu.tbadk.imageManager.c.Ed().fH(str3);
        if (fH == null) {
            Bitmap cO = ar.cO(com.baidu.adp.lib.h.b.g(str2, 0));
            if (cO == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cO, false, str2);
            com.baidu.tbadk.imageManager.c.Ed().c(str3, aVar);
            return aVar;
        }
        return fH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wK() {
        return this.acq;
    }
}
