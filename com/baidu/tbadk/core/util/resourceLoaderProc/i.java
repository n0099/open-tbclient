package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class i extends a {
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
    public boolean vm() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m411getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fq = com.baidu.tbadk.imageManager.c.BV().fq(str3);
        if (fq == null) {
            Bitmap cw = an.cw(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cw == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cw, false, str2);
            com.baidu.tbadk.imageManager.c.BV().c(str3, aVar);
            return aVar;
        }
        return fq;
    }
}
